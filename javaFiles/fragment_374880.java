public class DocumentBuilderTest {

 public static void main(String[] args) {
   try {
     InputStream is = new MyInputStream("project.xml");
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
     documentBuilder.parse(is);
   } catch (Exception e) {
     e.printStackTrace();
   }
 }

 static class MyInputStream extends FileInputStream {   
   public MyInputStream(String filename) throws FileNotFoundException {
     super(filename);
   }

   @Override
   public void close() throws IOException {
     // here we log when the stream is close.
     System.out.println("file input stream closed.");
     Exception e = new Exception();
     e.printStackTrace();
     super.close();
   }

 }
}