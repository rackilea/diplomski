import org.apache.commons.codec.binary.Base64;

public class MyTest {
    public static void main(String[] args) throws Exception {
        byte[] byteArray = new byte[] {100,25,28,-122,-26,94,-3,-26};
        System.out.println("To UTF-8 string: " + new String(byteArray, "UTF-8"));

        byte[] base64 = Base64.encodeBase64(byteArray);
        System.out.println("To Base64 string: " + new String(base64, "UTF-8"));

        byte[] decoded = Base64.decodeBase64(base64);
        System.out.println("Back to UTF-8 string: " + new String(decoded, "UTF-8"));

        /* the decoded byte array is the same as the original byte array */
        for (int i = 0; i < decoded.length; i++) {
            assert byteArray[i] == decoded[i];
        }
    }
}