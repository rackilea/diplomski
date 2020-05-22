InputStream is = entity.getContent();
String filePath = "sample.txt";
FileOutputStream fos = new FileOutputStream(new File(filePath));
int inByte;
while((inByte = is.read()) != -1)
     fos.write(inByte);
is.close();
fos.close();