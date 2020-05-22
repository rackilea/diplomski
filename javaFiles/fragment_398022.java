import codec.Base64; // or whatever which can use to base64 encoding
import static java.lang.System.out;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

...

   Security.addProvider(new BouncyCastleProvider());

   KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECIES", "BC");
   ECGenParameterSpec brainpoolP160R1 = new ECGenParameterSpec("brainpoolP160R1");

   // I'm Still using this 160 bit GF(*p*) to keep the algorithm running fast rather than 256 or above 
   kpg.initialize(brainpoolP160R1);

   KeyPair kp = kpg.generateKeyPair();

   PublicKey publicKey = kp.getPublic();
   PrivateKey privateKey = kp.getPrivate();

   byte[] PublicKey = publicKey.getEncoded();
   byte[] PrivateKey = privateKey.getEncoded();

   out.println("Encoded Public : "+Base64.encode(PublicKey));
   out.println("\nEncoded Private : "+Base64.encode(PrivateKey));
...