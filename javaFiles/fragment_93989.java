import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;  

public class Base64Encoder {

    private Base64 b64 = new Base64();

    public String encode(String message) {
        return b64.encodeAsString(message.getBytes());
    }

    public String decode(String message) {
        return new String(b64.decode(message), Charsets.UTF_8);
    }
}