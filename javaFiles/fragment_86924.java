FileOutputStream fos;
String path = Environment.getExternalStorageDirectory().getAbsolutePath();
String FILENAME =path + "/External"; // External is the text file name
String text = "Hello I am in External!"; // text inside the file
fos=new FileOutputStream(FILENAME);
fos.write(text.getBytes());
fos.close();