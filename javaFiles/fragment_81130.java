import java.io.*;

public class HelloWorld {
  public static void main(String[] args) throws Exception {
    String s = "喜\n";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    DataInputStream d = new DataInputStream(in);
    System.out.println(d.readLine()); // prints å

    in = new ByteArrayInputStream(s.getBytes());
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    System.out.println(br.readLine()); // prints 喜
  }
}