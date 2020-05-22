package playground.TEST.cxf_soap;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class BCCertUtils {

    public static KeyPair generateKeyPair(int keySize, String keyAlgo, String secureAlgo) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(keyAlgo != null && !keyAlgo.trim().isEmpty() ? keyAlgo : "RSA");
        keyGen.initialize(keySize, secureAlgo != null && !secureAlgo.trim().isEmpty() ? SecureRandom.getInstance(secureAlgo) : new SecureRandom());
        KeyPair pair = keyGen.generateKeyPair();
        return pair;
    }

    public static Certificate generateSelfSignedCertificate(KeyPair keyPair, String dn, String sigAlg, Date endDate)
            throws OperatorCreationException, CertificateException {

        // Setting bouncy castle provider to be able to create certs at all... 
        Provider bcProvider = new BouncyCastleProvider();
        Security.addProvider(bcProvider);
        X500Name dnName = new X500Name(dn);

        // Using the current timestamp as the certificate serial number
        BigInteger certSerialNum = new BigInteger(String.valueOf(System.currentTimeMillis()));

        // Setting start date
        Date startDate = Calendar.getInstance().getTime();

        // Use appropriate signature algorithm based on your keyPair algorithm.
        String sigAlgorithm = sigAlg == null || sigAlg.trim().isEmpty() ? "SHA256WithRSA" : sigAlg;

        SubjectPublicKeyInfo certPubKey = SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded());

        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(dnName, certSerialNum, startDate, endDate, dnName, certPubKey);

        ContentSigner contentSigner = new JcaContentSignerBuilder(sigAlgorithm).setProvider(bcProvider).build(keyPair.getPrivate());

        X509CertificateHolder certificateHolder = certBuilder.build(contentSigner);

        return new JcaX509CertificateConverter().getCertificate(certificateHolder);

    }

    public static void storeToPKCS12File(String alias, Certificate selfCert, String filename, char[] ksPass, char[] kePass, PrivateKey privKey)
            throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, OperatorCreationException {

        KeyStore p12Store = createP12Store(alias, selfCert, privKey, kePass);
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            p12Store.store(fos, ksPass);
        }
    }

    public static byte[] storeToPKCS12ByteArray(String alias, Certificate selfCert, char[] ksPass, char[] kePass, PrivateKey privKey)
            throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, OperatorCreationException {

        KeyStore p12Store = createP12Store(alias, selfCert, privKey, kePass);
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            p12Store.store(bos, ksPass);
            return bos.toByteArray();
        }

    }

    private static KeyStore createP12Store(String alias, Certificate selfCert, PrivateKey privKey, char[] kePass)
            throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

        KeyStore p12KeyStore = KeyStore.getInstance("PKCS12");
        p12KeyStore.load(null, null);

        KeyStore.Entry entry = new PrivateKeyEntry(privKey, new Certificate[] { selfCert });
        KeyStore.ProtectionParameter param = new KeyStore.PasswordProtection(kePass);

        p12KeyStore.setEntry(alias, entry, param);

        return p12KeyStore;
    }

    public static boolean moduliMatch(PublicKey originPubKey, PrivateKey certPrivKey) {
        return ((RSAPublicKey) originPubKey).getModulus().equals(((RSAPrivateKey) certPrivKey).getModulus());
    }

    public static KeyPair loadKeysFromPKCS12File(String alias, String filename, char[] storePass, char[] entryPass) throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {

        KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(filename);) {
            pkcs12KeyStore.load(fis, storePass);
        }

        return loadKeyPair(pkcs12KeyStore, alias, entryPass);
    }

    public static KeyPair loadKeysFromPKCS12ByteArray(String alias, byte[] storeBytes, char[] storePass, char[] entryPass) throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {

        KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12");
        try (ByteArrayInputStream bis = new ByteArrayInputStream(storeBytes);) {
            pkcs12KeyStore.load(bis, storePass);
        }

        return loadKeyPair(pkcs12KeyStore, alias, entryPass);
    }

    private static KeyPair loadKeyPair(KeyStore ks, String alias, char[] entryPass)
            throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        KeyStore.ProtectionParameter param = new KeyStore.PasswordProtection(entryPass);
        Entry entry = ks.getEntry(alias, param);
        if (!(entry instanceof PrivateKeyEntry)) {
            throw new KeyStoreException("That's not a private key!");
        }
        PrivateKeyEntry privKeyEntry = (PrivateKeyEntry) entry;
        PublicKey publicKey = privKeyEntry.getCertificate().getPublicKey();
        PrivateKey privateKey = privKeyEntry.getPrivateKey();
        return new KeyPair(publicKey, privateKey);
    }

    public static Certificate loadCertFromPKCS12File(String alias, String filename, char[] storePass, char[] entryPass) throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {

        KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(filename);) {
            pkcs12KeyStore.load(fis, storePass);
        }
        return loadCert(pkcs12KeyStore, alias, entryPass);
    }

    public static Certificate loadCertFromPKCS12ByteArray(String alias, byte[] storeBytes, char[] storePass, char[] entryPass)
            throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException,
            UnrecoverableEntryException {

        KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12");
        try (ByteArrayInputStream bis = new ByteArrayInputStream(storeBytes);) {
            pkcs12KeyStore.load(bis, storePass);
        }
        return loadCert(pkcs12KeyStore, alias, entryPass);
    }

    private static Certificate loadCert(KeyStore ks, String alias, char[] entryPass)
            throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {

        KeyStore.ProtectionParameter param = new KeyStore.PasswordProtection(entryPass);
        Entry entry = ks.getEntry(alias, param);
        if (!(entry instanceof PrivateKeyEntry)) {
            throw new KeyStoreException("That's not a private key!");
        }
        PrivateKeyEntry privKeyEntry = (PrivateKeyEntry) entry;
        return privKeyEntry.getCertificate();
    }

    public static void storeToPEMFile(Certificate pubCert, String certPath) throws IOException {
        JcaPEMWriter pw = new JcaPEMWriter(new FileWriter(certPath));
        pw.writeObject(pubCert);
        pw.flush();
        pw.close();

    }

    public static byte[] storeToPEMByteArray(Certificate pubCert) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(baos));
        JcaPEMWriter pw = new JcaPEMWriter(writer);
        pw.writeObject(pubCert);
        pw.flush();
        pw.close();
        return baos.toByteArray();

    }

}