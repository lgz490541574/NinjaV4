
## :smile:����ʲô  
+ Զ�̲鿴����WiFi���豸�������  
+ Զ�̿����ֻ�¼��Bվ/����/����/����ֱ��  
    
    
## :smile:��Ҫʲô  
+ һ̨Android�ֻ�(���Բ���Root)   
    + ��װTermux
    + ��װTermux��Tasker
    + ��װTasker
    + ��զ��Ŀ��Կ���ǰ���[����](https://nICEnnnnnnnLee.github.io/blog/2019/09/07/android-linux-3/)  
+ һ��Github�˺�  
    + ����Repo������״̬��ȡ�����񷢲�  
+ һ������õ�dex���� [ninjaV4.dex](https://github.com/nICEnnnnnnnLee/NinjaV4/releases)


## :smile:��β���  
<details>
<summary>Github</summary>


+ �½�һ�����ڼ�Ȩ��token
+ �½�һ��Repo(������˽��),����`AbcTest`
+ Ϊ�˷���ʶ�������豸����Ӷ�MAC��ַ�ı�ע����`online-devices/remarks.txt`  
```
2b:2b:2b:2b:2b:2b �ҵ�PC
2b:2b:2b:2b:2b:2c �ҵ��ֻ�
```
</details>


<details>
<summary>Termux</summary>


+ ��װ
����ϸ�������[����](https://nICEnnnnnnnLee.github.io/blog/2019/09/17/android-linux-8/)
```
wget install.sh https://gitee.com/NiceLeee/NinjaV4/raw/master/auto-install/install.sh
bash install.sh
```

+ ����
```
cd ~/workspace/ninjaV4/config
vi app.config
```
�����г��ز����ٵĹؼ����ã������ɲο�`app.config.sample`
```
# token ���ڷ���github
token = xxxxxxxx
# �����豸�ϴ���λ��
#�������{nICEnnnnnnnLee}��{AbcTest}�ֿ��{online-devices/onlines.txt}���Կ����ҵ�WiFi�豸״̬
url_onlineDevices = https://api.github.com/repos/nICEnnnnnnnLee/AbcTest/contents/online-devices/onlines.txt
# ��MAC��ַ�ı�ע���������{nICEnnnnnnnLee}��{AbcTest}�ֿ��{online-devices/remarks.txt}
url_markOfMacs = https://raw.githubusercontent.com/nICEnnnnnnnLee/AbcTest/master/online-devices/remarks.txt
# �����ƶ��·�����
url_taskToDo = https://raw.githubusercontent.com/nICEnnnnnnnLee/AbcTest/master/task/todo.txt
# ��������ִ������ϱ�
url_taskReport = https://api.github.com/repos/nICEnnnnnnnLee/AbcTest/contents/task/report.txt
```

+ ����  
```
bash ~/run_ninjaV4.sh
```
</details>
 
<details>
<summary>Tasker</summary>


+ �����Դ���WiFi״̬�ϴ�
    + Tasker�������
    + �����Ի���ѡ����
    + �����Ի���ѡ��termux:task
    + �����Ի���ѡ��ű�wifi_status_upload.sh
    + ����ÿ30���Ӵ���һ��
    
+ �����Դ����ƶ������ȡ��ִ��
    + Tasker�������
    + �����Ի���ѡ����
    + �����Ի���ѡ��termux:task
    + �����Ի���ѡ��ű�get_command_and_run.sh
    + ����ÿ5���Ӵ���һ��
</details>

    
## :smile:���ʹ��  
<details>
<summary>ͬһ��������</summary>


�����ֻ�IPΪ:**192.168.0.101**  
���������`http://192.168.0.101:8888/`,���Եõ����½����  
![](https://nICEnnnnnnnLee.github.io/sources/archive/2019/09/index-page.png)   


������ʾ�������ɡ�  
����ֱ��¼�Ʋ���״̬��ѯ��    
![](https://nICEnnnnnnnLee.github.io/sources/archive/2019/09/live-recorder.png)  
</details>

<details>
<summary>Զ�̲���</summary>


+ �鿴���ڵ�WiFi����״̬  
��Github��Ӧ��Repo·���鿴����  
![](https://nICEnnnnnnnLee.github.io/sources/archive/2019/09/onliner.png)  

+ �ü��ڵ�Android�豸ִ��ĳЩ�ض�����  
    + ��Ϊ��ÿ5����ȡһ�Σ���һ���ӳ١�  
    + �༭����ָ���õ�λ�õ��ļ�����`task/todo.txt`

+ �����ʽ˵��  
    + �����ţ� ��Ҫ�ϸ��������ų���99999�Ժ��0��ʼ
    + �ƻ�ʱ�䣺 ����`18:15`,`18:20`��ȡһ����������`18:18`,`18:19`�����񶼽���`18:20`����ִ�У���ִ��˳��û��ȷ��
    + �������ݣ� ��������ڸ��������ַURLһ�£����磺  
        + ¼��bվĳ������ /live/start?liver=bili&id=6&qn=10000  
        + ¼�ƶ���ĳ������ /live/start?liver=douyu&id=233223&qn=0  
        + ֹͣ����¼�ƣ� /live/stopAll
        + ����WiFi�豸����״̬�� /onliner/status/upload
```
������ �ƻ�ʱ�� ��������
1 2019-09-16 14:14 /test
2 2019-09-16 14:14 /cloud/history/delete
3 2019-09-17 18:18 /onliner/status/upload
4 2019-09-17 18:19 /onliner/status/upload
5 2019-09-17 18:45 /onliner/status/upload
6 2019-09-17 20:46 /onliner/status/upload
```
</details> 


## :smile:������ʹ������   
+ ʹ��[JSON.org](https://github.com/stleary/JSON-java)�����򵥵�Json����[![](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/stleary/JSON-java/blob/master/LICENSE) 
+ ʹ��[Crypto-js](https://github.com/brix/crypto-js)����������ɶ���ֱ��¼��token[![](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/brix/crypto-js/blob/develop/LICENSE) 
+ ʹ��[Rhino](https://github.com/brix/crypto-js)���ڶ���ֱ��¼������tokenʱ������js[![](https://img.shields.io/badge/license-MPL%202.0-green.svg)](https://github.com/mozilla/rhino/blob/master/LICENSE.txt) 

## :smile:LICENSE
```
Copyright (C) 2019 NiceLee. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
