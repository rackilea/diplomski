NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("D://protectedfile.xlsx"));
EncryptionInfo info = new EncryptionInfo(fs);
Decryptor d = Decryptor.getInstance(info);
if (d.verifyPassword("password")) {
   XSSFWorkbook wb = new XSSFWorkbook(d.getDataStream(fs));
} else {
   // Password is wrong
}