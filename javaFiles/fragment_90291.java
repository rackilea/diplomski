String rootPath = "/home/user/";
String downlods = "downloads";

String realPathtoUploads = rootPath + downlods ;

if(! new File(realPathtoUploads).exists()) {
  new File(realPathtoUploads).mkdir();
}