import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

public class RsaVerify {

    public static void main(String args[]){
        String publicKey = 
//              "-----BEGIN PUBLIC KEY-----"+
                "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANDiE2+Xi/WnO+s120NiiJhNyIButVu6"+
                "zxqlVzz0wy2j4kQVUC4ZRZD80IY+4wIiX2YxKBZKGnd2TtPkcJ/ljkUCAwEAAQ==";
//              "-----END PUBLIC KEY-----";

        byte[] data = "For my current project I have to send a signature from PHP to Java application. I am using Crypt/RSA right now for signing my data.".getBytes();
        byte[] signature = Base64.decodeBase64("OnqiWnFQ2nAjOa1S57Du9jDpVr4Wp2nLdMk2FX+/qX1+SAHpVsW1JvQYqQUDlxvbTOE9vg6dlU6i3omR7KipLw==");

        try {
            System.out.println(verify(data, signature, publicKey));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }

    private static boolean verify(byte[] data, byte[] signature, String publicKey) throws GeneralSecurityException{
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(pubKey);
        sig.update(data);
        return sig.verify(signature);
    }
}