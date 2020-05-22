import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Test {

    private static SecretKey secretKey;
    private static KeyPair keyPair;
    private static final String STRINGTOENCRYPT = "This is a test";
    private static String stringEncripted;
    private static byte[] ct;
    private static String keyEncripted;
    private static byte[] wrapped;
    public static final byte[] IV_PARAM = {0x00, 0x01, 0x02, 0x03,
            0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0A, 0x0B,
            0x0C, 0x0D, 0x0E, 0x0F};


    public static void main(String[] args) {
        generateKeys();
    }

    private static void generateKeys() {

        secretKey = generateSecretKey(128);
        keyPair = generateKeyPair(512);
        stringEncripted = encriptString(STRINGTOENCRYPT);
        keyEncripted = encriptKey(keyPair.getPublic());

        decryptString();

    }

    private static void decryptString() {
        Cipher cipher = null;
        Key keyDecrypted = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.UNWRAP_MODE, keyPair.getPrivate());
            // keyDecrypted = cipher.unwrap(keyEncripted.getBytes(), "AES", Cipher.SECRET_KEY);
            keyDecrypted = cipher.unwrap(wrapped, "AES", Cipher.SECRET_KEY);

            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(IV_PARAM);
            cipher.init(Cipher.DECRYPT_MODE, keyDecrypted, iv);
            byte[] stringDecryptedBytes = cipher.doFinal(ct);
            String stringDecrypted = new String(stringDecryptedBytes);

            System.out.println(stringDecrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static KeyPair generateKeyPair(int lenght) {
        KeyPair keyPublicAndPrivate = null;

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(lenght);
            keyPublicAndPrivate = keyGen.genKeyPair();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return keyPublicAndPrivate;

    }

    private static SecretKey generateSecretKey(int lenght) {


        SecretKey sKey = null;
        if ((lenght == 128) || (lenght == 192) || (lenght == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(lenght);
                sKey = kgen.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        }
        return sKey;

    }

    private static String encriptString(String stringtoencrypt) {

        byte[] stringtoencryptBytes = stringtoencrypt.getBytes();
        Cipher cipher = null;

        String stringEncrypted = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(IV_PARAM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            // byte[] stringEncryptedBytes = cipher.doFinal(stringtoencryptBytes);
            ct = cipher.doFinal(stringtoencryptBytes);
            stringEncrypted = new String(cipher.doFinal(stringtoencryptBytes), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return stringEncrypted;
    }


    private static String encriptKey(PublicKey aPublic) {
        String keyEncryptedString = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.WRAP_MODE, aPublic);
//            byte[] keyEncriptedBytes = cipher.wrap(secretKey);
//            keyEncryptedString = new String(keyEncriptedBytes, "UTF-8");
            wrapped = cipher.wrap(secretKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyEncryptedString;
    }

}