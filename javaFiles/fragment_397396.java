import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemReader;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public static void main(String privateKeyPath, String publicKeyPath, String encodedStringPath, boolean isPublicKeyAndDataBase64) throws FileNotFoundException,
            IOException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());

        String encodedString = readFileAsString(encodedStringPath);
        if(isPublicKeyAndDataBase64) {
            KeyFactory factory = KeyFactory.getInstance("RSA", "BC");
            Timber.w("Encoded String converted from base64: %s", decodeBase64ToBytesa(encodedString));
            try {
                PrivateKey priv = generatePrivateKey(factory, privateKeyPath);
                Timber.i(String.format("Instantiated private key: %s", priv));
                decipherString(priv, decodeBase64ToBytesa(encodedString));
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
            return;
        }
        else
            Timber.w("Encoded String: %s", encodedString);

        KeyFactory factory = KeyFactory.getInstance("RSA", "BC");
        try {
            PrivateKey priv = generatePrivateKey(factory, privateKeyPath);
            Timber.i(String.format("Instantiated private key: %s", priv));
            decipherString(priv, encodedString.getBytes());
            PublicKey pub = generatePublicKey(factory, publicKeyPath);
            Timber.i(String.format("Instantiated public key: %s", pub));
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private static PrivateKey generatePrivateKey(KeyFactory factory,
                                                 String filename) throws InvalidKeySpecException,
            FileNotFoundException, IOException {
        PemFile pemFile = new PemFile(filename, false);
        byte[] content = pemFile.getPemObject().getContent();
        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
        return factory.generatePrivate(privKeySpec);
    }

    private static PublicKey generatePublicKey(KeyFactory factory,
                                               String filename) throws InvalidKeySpecException,
            FileNotFoundException, IOException {
        PemFile pemFile = new PemFile(filename, false);
        byte[] content = pemFile.getPemObject().getContent();
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
        return factory.generatePublic(pubKeySpec);
    }

    private static void decipherString(PrivateKey privateKey, byte[] encodedStringData) {
        byte[] dectyptedText = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            dectyptedText = cipher.doFinal(encodedStringData);
            Timber.w("Deciphered text is: %s", new String(dectyptedText));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class PemFile {

        private PemObject pemObject;

        public PemFile(String filename, boolean isBase64) throws FileNotFoundException, IOException {
            PemReader pemReader = null;

            if(isBase64) {
                Timber.i("reading base64 encoded pem file. base64DecodedString: %s", decodeBase64(filename));
                pemReader = new PemReader(new StringReader(decodeBase64(filename)));
            }
            else
                pemReader = new PemReader(new InputStreamReader(
                        new FileInputStream(filename)));
            try {
                this.pemObject = pemReader.readPemObject();
            }
            catch (Exception e) {
                e.printStackTrace();
            }finally {
                pemReader.close();
            }
        }

        public PemObject getPemObject() {
            return pemObject;
        }
    }