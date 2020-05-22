import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Main {

    public static void main(String[] args) throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "BC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp521r1"), new SecureRandom());
        java.security.KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println(privateKey.getFormat());
        PublicKey publicKey = keyPair.getPublic();
        System.out.println(publicKey.getFormat());

        // A KeyFactory is used to convert encoded keys to their actual Java classes
        KeyFactory ecKeyFac = KeyFactory.getInstance("EC", "BC");

        // Now do a round-trip for a private key,
        byte [] encodedPriv = privateKey.getEncoded();
        // now take the encoded value and recreate the private key
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(encodedPriv);
        PrivateKey privateKey2 = ecKeyFac.generatePrivate(pkcs8EncodedKeySpec);

        // And a round trip for the public key as well.
        byte [] encodedPub = publicKey.getEncoded();
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(encodedPub);
        PublicKey publicKey2 = ecKeyFac.generatePublic(x509EncodedKeySpec);
        System.out.println(publicKey2);

    }
}