import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md5 = MessageDigest.getInstance("SHA-384");
        byte[] state = new byte[]{1};
        byte[] digest = md5.digest(state);
        System.out.println("A: " + Arrays.toString(digest));
        md5 = MessageDigest.getInstance("SHA3-384");
        digest = md5.digest(state);
        System.out.println("B: " + Arrays.toString(digest));
        SHA3.DigestSHA3 sha3 = new SHA3.DigestSHA3(384);
        digest = sha3.digest(state);
        System.out.println("C: " + Arrays.toString(digest));
    }
}