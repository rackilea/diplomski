String parentName = "";
java.io.File parentFile = null;
while (!"WEB-INF".equals(parentName)) {
  File file = new File(decodedPath);
  parentFile = file.getParentFile();
  parentName = parentFile.getName();
  decodedPath = parentFile.getAbsolutePath();               
  }
String realWarName = parentFile.getParentFile().getName();