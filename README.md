# AlistUtil.jar

---

总所周知，Alist是一款轻量好用的文件管理共享平台，可以基于Docker部署，官方文档中也给除了很多对外Api接口，在此我使用Java语言开发了一套操作Alist的工具类，使用方法特别简单，在下面给出示例代码以及对应功能。

- 初始化AlistConfig对象 (所有方法的前提)

  ```java
  AlistConfig alistConfig = new AlistConfig("http://localhost:5244","admin","123456");
  //传入alist地址，用户名，密码即可
  ```

  **注意：由于代码没有完善的原因，传入的alist地址后千万不要带`/`，否则会报错，后续版本会修复此BUG**

- 获取指定目录下列表

  ```java
  String alistFileList = AlistUtils.getAlistFileList(alistConfig, "/files/test");
  //传入实例化的AlistConfig对象和路径即可
  ```

- 获取指定文件信息

  ```java
  String alistFileInfo = AlistUtils.getAlistFileInfo(alistConfig, "/files/test/test.txt", "");
  //传入实例化的AlistConfig对象、路径以及文件密码即可 文件密码若没设置可以为空
  ```

- 递归获取指定目录下所有文件的下载直链

  ```java
  ArrayList<HashMap<String, String>> alistAllFilesInfo = AlistUtils.getAlistAllFilesInfo(alistConfig, "/files/test", "");
  //传入实例化的AlistConfig对象、路径以及文件密码即可 文件密码若没设置可以为空
  //返回的ArrayList集合中会包含所有的文件对应路径以及下载地址的键值对集合
  ```

- 上传文件

  ```java
  AlistUtils.uploadFile(alistConfig, "D:/files/test/test.txt", "/files/test/test","test.txt");
  //传入实例化的AlistConfig对象、源文件、目标目录、传入后文件名
  ```

  **注意：该方法会抛出IOException，需要大家自己捕获处理一下异常信息**