import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mp3ToHex {

  public static void main(String[] args) throws IOException {
    //directories
    String fileIn = "Some\\Input\\Directory\\input.mp3",
      fileOut = "Some\\Output\\Directory\\out.txt",
      log = "Some\\Log\\Directory\\log.txt",
      debug = "Some\\Debug\\Directory\\debug.mp3";

    BufferedWriter br = new BufferedWriter(new FileWriter(fileOut)),
      brL = new BufferedWriter(new FileWriter(log)),
      brD = new BufferedWriter(new FileWriter(debug));
    String s = readFile(fileIn, Charset.forName(StandardCharsets.ISO_8859_1.name()));
    brD.write(s);
    byte[] bytes = s.getBytes();
    brL.write(bytesToHex(s.getBytes()));
    StringBuilder binary = new StringBuilder();
    for (byte b: bytes) {
      int val = b;
      for (int i = 0; i < 8; i++) {
        binary.append((val & 128) == 0 ? 0 : 1);
        val <<= 1;
      }
      binary.append(' ');

    }
    br.write(binary + "");
    br.close();
  }
  static String readFile(String path, Charset encoding)
  throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }
  private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = hexArray[v >>> 4];
      hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
  }

}