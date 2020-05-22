import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.conscrypt.Conscrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

public class ConscryptIssue1 {

    private final static Provider CONSCRYPT = Conscrypt.newProvider();
    private final static Provider BC = new BouncyCastleProvider();

    public static void main(String[] args) throws GeneralSecurityException {
        Security.addProvider(CONSCRYPT);
        doExample();
    }

    private static void doExample() throws GeneralSecurityException {
        final SecureRandom secureRandom = new SecureRandom();
        {
            // first, try with Conscrypt
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256, secureRandom);
            SecretKey aesKey = keyGenerator.generateKey();
            byte[] plaintext = new byte[10000]; // plaintext is all zeros
            byte[] nonce = new byte[12];
            secureRandom.nextBytes(nonce);
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding", CONSCRYPT);// specify the provider explicitly
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce);// tag length is specified in bits.
            c.init(Cipher.ENCRYPT_MODE, aesKey, spec);
            byte[] outBuf = new byte[c.getOutputSize(512)];
            int numProduced = c.update(plaintext, 0, 512, outBuf, 0);
            System.out.println(numProduced);
            final int finalProduced = c.doFinal(outBuf, numProduced);
            System.out.println(finalProduced);
        }

        {
            // Next, try with Bouncycastle
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256, secureRandom);
            SecretKey aesKey = keyGenerator.generateKey();
            byte[] plaintext = new byte[10000]; // plaintext is all zeros
            byte[] nonce = new byte[12];
            secureRandom.nextBytes(nonce);
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding", BC);// specify the provider explicitly
            GCMParameterSpec spec = new GCMParameterSpec(128, nonce);// tag length is specified in bits.
            c.init(Cipher.ENCRYPT_MODE, aesKey, spec);
            byte[] outBuf = new byte[c.getOutputSize(512)];
            int numProduced = c.update(plaintext, 0, 512, outBuf, 0);
            System.out.println(numProduced);
            final int finalProduced = c.doFinal(outBuf, numProduced);
            System.out.println(finalProduced);
        }

    }
}