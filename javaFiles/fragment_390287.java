import org.apache.commons.codec.digest.DigestUtils;

public class HashTest {
    public static String cipher(String pwd, String salt) {
        return DigestUtils.sha256Hex(pwd+salt);
    }
    public static void main(String[] args) {
        String p = "password";
        String s = "randomSalt";
        String c = cipher(p, s);
        System.out.println(c);
    }
}