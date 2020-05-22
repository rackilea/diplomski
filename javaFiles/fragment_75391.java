try {
File file = new File("C:\\Users\\ABC\\Desktop\\xml.txt");
InputStream myScan = new FileInputStream(file);
byte[] b = new byte[(int)file.length()];
myScan.read(b);
String cowo = new String(b);
System.out.println( cowo );
String decoded = new String(DatatypeConverter.parseBase64Binary(cowo));
String cat = b.toString();
System.out.println(decoded);
byte[] bArray = cat.getBytes();
    OutputStream out = new FileOutputStream("C:\\Users\\ABC\\Desktop\\cow.xml");
    out.write(decoded.getBytes());
    out.close();
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}