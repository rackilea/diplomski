BufferedInputStream bis = new BufferedInputStream(entity.getContent());
String filePath = "sample.txt";
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
int inByte;
while((inByte = bis.read()) != -1) bos.write(inByte);
bis.close();
bos.close();