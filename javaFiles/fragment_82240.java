import java.io.*;

public class NoLoopReader {
  public static void main (String[] args) throws Exception {
    String fileName = args[0];
    InputStream is = new BufferedInputStream(new FileInputStream(fileName));
    File file = new File(fileName);
    int size = (int)file.length();

    byte[] buffer = new byte[size];
    is.read(buffer,0,size);
  }
}