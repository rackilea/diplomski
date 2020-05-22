path = "C:/Users/Kasper/Documents/testingimport.sql";
InputStream fileInputStream = new FileInputStream(new File(path));
byte[] b = new byte[4096];
while(fileInputStream.read(b) != -1) {
    p.getOutputStream().write(b);
}
process.getOutputStream().close(); // don't forget to close!