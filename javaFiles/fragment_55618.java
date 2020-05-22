$ cat rsa_java.java 
import java.io.*;
import java.util.*;
import java.security.*;

public class rsa_java {
    public static void main (String[] args) throws Exception {

    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(4096);
    KeyPair keyPair = keyGen.genKeyPair();

    PrivateKey privateKey = keyPair.getPrivate();
    byte[] encodedPrivateKey = privateKey.getEncoded();
    String b64Encoded = Base64.getEncoder().encodeToString(encodedPrivateKey);

    try (PrintStream out = new PrintStream(new FileOutputStream("rsa_key.txt")))
    {
        out.print(b64Encoded);
    }
}