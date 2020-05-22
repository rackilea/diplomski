String fileUrl = "/appname/data.xml";
String file = android.os.Environment.getExternalStorageDirectory().getPath() + fileUrl;
File f = new File(file);

if(f.exists())
return;