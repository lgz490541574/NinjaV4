package nicelee.server.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nicelee.PackageScanLoader;
import nicelee.common.annotation.Controller;
import nicelee.common.annotation.Value;

public class PathDealer {

	/**
	 * 处理请求
	 * @param out
	 * @param path
	 * @param param
	 * @throws IOException
	 */
	public void dealRequest(BufferedWriter out, String path, String param) throws IOException {
		dealRequest(out, path, param, false);
	}

	public void dealRequest(BufferedWriter out, String path, String param, boolean isCmd) throws IOException {
		// 遍历Controller类，得到和Path匹配的处理方法, 目前仅一个Class
		Method currentMethod = null;
		currentMethod = findMethod(path, currentMethod);
		// 找到Method方法后，根据param给Method变量赋值
		if (currentMethod != null) {
			dealWithPathKnown(out, param, currentMethod);
		} else {
			dealWithPathUnknown(out,isCmd);
		}
	}

	/**
	 * 寻找匹配Method的方法
	 * 
	 * @param path
	 * @param currentMethod
	 * @return
	 */
	private Method findMethod(String path, Method currentMethod) {
		for (Class<?> klass : PackageScanLoader.controllerClazzes) {
			Controller preAnno = klass.getAnnotation(Controller.class);
			String pathPrefix = preAnno.path();
			for (Method method : klass.getMethods()) {
				Controller controller = method.getAnnotation(Controller.class);
				if (controller != null && (pathPrefix + controller.path()).equals(path)) {
					currentMethod = method;
					break;
				}
			}
		}
		return currentMethod;
	}

	/**
	 * @param param
	 * @param currentMethod
	 * @param klass
	 * @throws Exception
	 */
	private void dealWithPathKnown(BufferedWriter out, String param, Method currentMethod) {
		Class<?> klass = currentMethod.getDeclaringClass();
		Annotation[][] paramAnnos = currentMethod.getParameterAnnotations();
		Class<?>[] paramTypes = currentMethod.getParameterTypes();
		Object[] values = new Object[paramTypes.length];
		for (int i = 0; i < paramTypes.length; i++) {
			// 如果是BufferedWriter，那么直接赋值，否则从params中找
			if (paramTypes[i] == BufferedWriter.class) {
				values[i] = out;
			} else {
				if (paramAnnos[i].length > 0) {
					Value value = (Value) paramAnnos[i][0];
					values[i] = getValue(param, value.key());
				} else {
					values[i] = null;
				}
			}
		}
		// 实例化Controller，并执行该方法
		try {
			String result = (String) currentMethod.invoke(klass.newInstance(), values);
			if (result != null) {
				out.write(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(klass.getName());
			System.out.println(currentMethod.getName());
			for (Object obj : values) {
				System.out.println(obj);
			}
		}
	}

	/**
	 * 处理不知道的路径
	 * 
	 * @param out
	 * @param isCmd 是否直接返回command not found；还是返回引导页面
	 * @throws IOException
	 */
	private void dealWithPathUnknown(BufferedWriter out, boolean isCmd) throws IOException {
		if (isCmd) {
			out.write("command not found");
			return;
		}
		out.write("<html><head><title>Index</title></head><body><ul>");
		for (Class<?> klass : PackageScanLoader.controllerClazzes) {
			Controller preAnno = klass.getAnnotation(Controller.class);
			String pathPrefix = preAnno.path();
			out.write(preAnno.note());
			for (Method method : klass.getMethods()) {
				Controller controller = method.getAnnotation(Controller.class);
				if (controller != null) {
					out.write("<li><a href=\"");
					out.write(pathPrefix + controller.path());
					out.write("\">");
					out.write(controller.note());
					out.write("</a>--------------------------<a href=\"");
					out.write(pathPrefix + controller.path());
					out.write("\">");
					out.write(pathPrefix + controller.path());
					out.write("</a></li>");
				}
			}
			out.write("<hr/>");
		}
		out.write("</ul></body></html>");
	}

	/**
	 * 从参数字符串中取出值 "key1=value1&key2=value2 ..."
	 * 
	 * @param param
	 * @param key
	 * @return
	 */
	private static String getValue(String param, String key) {
		Pattern pattern = Pattern.compile(key + "=([^&]*)");
		Matcher matcher = pattern.matcher(param);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
}
