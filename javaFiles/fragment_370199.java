import java.math.BigInteger;
import org.apache.commons.codec.binary.Base64;

public class Main {
  public static void main(String... args) {
    String hexadecimal = "6a95b4dd5419f2ffb9f655309c931cb0";
    System.out.println("hexadecimal: " + hexadecimal);

    BigInteger bigint = new BigInteger(hexadecimal, 16);

    StringBuilder sb = new StringBuilder();
    byte[] ba = Base64.encodeInteger(bigint);
    for (byte b : ba) {
        sb.append((char)b);
    }
    String s = sb.toString();
    System.out.println("base64: " + s);
    System.out.println("encoded: " + Base64.isBase64(s));
  }
}

//Output:
//hexadecimal: 6a95b4dd5419f2ffb9f655309c931cb0
//base64: apW03VQZ8v+59lUwnJMcsA==
//encoded: true