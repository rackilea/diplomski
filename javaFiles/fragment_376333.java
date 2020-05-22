FileInputStream fis = new FileInputStream(f);
BufferedInputStream bis = new BufferedInputStream(fis);
int abyte;
while ((abyte = bis.read()) != -1 ){
    write(abyte);
}