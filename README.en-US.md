# AlistUtil.jar

---

As everyone knows, Alist is a lightweight and useful file management and sharing platform that can be deployed via Docker. The official documentation provides many external API interfaces. Here, I have developed a set of utility classes for operating Alist using the Java language. The usage is very simple; example code and corresponding functions are provided below.

- Add Dependency (Maven)
  ```xml
  <dependency>
    <groupId>io.github.1530624156</groupId>
    <artifactId>AlistUtil</artifactId>
    <version>1.0.1</version>
  </dependency>
  ```

- Initialize AlistConfig Object (Prerequisite for all methods)

  ```java
  AlistConfig alistConfig = new AlistConfig("http://localhost:5244","admin","123456");
  // Simply pass the alist address, username, and password
  ```

  **Note: Due to incomplete code, do not include a trailing `/` in the alist address, otherwise it will throw an error. This BUG will be fixed in future versions [Fixed].**

- Get the list of a specified directory

  ```java
  String alistFileList = AlistUtils.getAlistFileList(alistConfig, "/files/test");
  // Simply pass the instantiated AlistConfig object and the path
  ```

- Get information for a specified file

  ```java
  String alistFileInfo = AlistUtils.getAlistFileInfo(alistConfig, "/files/test/test.txt", "");
  // Pass the instantiated AlistConfig object, path, and file password. If no password is set, it can be empty.
  ```

- Recursively get the direct download links for all files in a specified directory

  ```java
  ArrayList<HashMap<String, String>> alistAllFilesInfo = AlistUtils.getAlistAllFilesInfo(alistConfig, "/files/test", "");
  // Pass the instantiated AlistConfig object, path, and file password. If no password is set, it can be empty.
  // The returned ArrayList collection will contain a set of key-value pairs consisting of all file paths and their corresponding download addresses.
  ```

- Upload File

  ```java
  AlistUtils.uploadFile(alistConfig, "D:/files/test/test.txt", "/files/test/test","test.txt");
  // Pass the instantiated AlistConfig object, source file, destination directory, and the target filename.
  ```

  **Note: This method throws an IOException; please capture and handle the exception information yourself.**
