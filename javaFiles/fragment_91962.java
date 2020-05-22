//1. read the path of the .class file/JAR. Working in both cases.
String  path = URLDecoder.decode(getClass().getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");

//2. get the parent folder path where the .class file/JAR is located.
//Note: "path" only contains "/", not File.separator, because it's an URL.
String appPath = path.substring(0, lastIndexOf("/"));

//3. Construct a File with the parent folder + separator + file name.
File f = new File(appPath + File.seperator + "someFileName.txt");