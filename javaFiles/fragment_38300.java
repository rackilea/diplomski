import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ENCODING_TYPE = "UTF-8";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION_VALUE = "AES/GCM/NoPadding";

    public static void setKey(String myKey, String hashingType) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(ENCODING_TYPE);
            sha = MessageDigest.getInstance(hashingType);
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException "+e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception Occured! "+e.getMessage());
        }
    }

    public static String encrypt(String strToEncrypt, String secret, String hashingType) {
        String encryptedString = null;
        try {
            byte[] nonce = new byte[12];
            setKey(secret,hashingType);
            SecureRandom random = SecureRandom.getInstanceStrong();
            random.nextBytes(nonce);
            final Cipher encryptCipher = Cipher.getInstance(TRANSFORMATION_VALUE);
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(16 * 8, nonce));
            byte[] cipheredString = encryptCipher.doFinal(strToEncrypt.getBytes());
            ByteBuffer byteBuffer = ByteBuffer.allocate(nonce.length + cipheredString.length);
            byteBuffer.put(nonce);
            byteBuffer.put(cipheredString);
            encryptedString = Base64.getEncoder().encodeToString(byteBuffer.array());       //Encoding the ByteArrayOutputStream result object to Base64 format
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Error while encrypting "+e.getMessage());
        }
        return encryptedString;
    }

    public static String decrypt(String strToDecrypt, String secret, String hashingType) {
        String decryptedString = null;
        try {
            byte[] nonce = new byte[12];
            setKey(secret,hashingType);
            final Cipher decryptCipher = Cipher.getInstance(TRANSFORMATION_VALUE);
            ByteBuffer byteBuffer = ByteBuffer.wrap(Base64.getDecoder().decode(strToDecrypt));
            byteBuffer.get(nonce);
            byte[] cipheredString = new byte[byteBuffer.remaining()];
            byteBuffer.get(cipheredString);
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(16 * 8, nonce));
            decryptedString = new String(decryptCipher.doFinal(cipheredString));
        } catch (Exception e) {
            System.out.println("Error while decrypting "+e.getMessage());
        }
        return decryptedString;
    }
}