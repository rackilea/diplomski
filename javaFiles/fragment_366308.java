import java.io.ByteArrayOutputStream;

public class OutputStreamEx {

 public static void main(String[] args) {
    String content = "Hello world";
    byte[] bytes = content.getBytes();
    try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(bytes, 0, bytes.length);
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        out.writeTo(out2);
        System.out.println(out2.toString());
     } catch (Exception ex) {
        ex.printStackTrace();
     }
  }
 }