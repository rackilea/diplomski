import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.util.encoders.Hex;

public class StoreRSAKeyPairInPKCS12 {

    public static void main(String[] args) throws Exception {

        // --- generate a key pair (you did this already it seems)
        KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
        final KeyPair pair = rsaGen.generateKeyPair();

        // --- create the self signed cert
        Certificate cert = createSelfSigned(pair);

        // --- create a new pkcs12 key store in memory
        KeyStore pkcs12 = KeyStore.getInstance("PKCS12");
        pkcs12.load(null, null);

        // --- create entry in PKCS12
        pkcs12.setKeyEntry("privatekeyalias", pair.getPrivate(), "entrypassphrase".toCharArray(), new Certificate[] {cert});

        // --- store PKCS#12 as file
        try (FileOutputStream p12 = new FileOutputStream("mystore.p12")) {
            pkcs12.store(p12, "p12passphrase".toCharArray());
        }

        // --- read PKCS#12 as file
        KeyStore testp12 = KeyStore.getInstance("PKCS12");
        try (FileInputStream p12 = new FileInputStream("mystore.p12")) {
            testp12.load(p12, "p12passphrase".toCharArray());
        }

        // --- retrieve private key
        System.out.println(Hex.toHexString(testp12.getKey("privatekeyalias", "entrypassphrase".toCharArray()).getEncoded()));
    }

    private static X509Certificate createSelfSigned(KeyPair pair) throws OperatorCreationException, CertIOException, CertificateException {
        X500Name dnName = new X500Name("CN=publickeystorageonly");
        BigInteger certSerialNumber = BigInteger.ONE;

        Date startDate = new Date(); // now

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1);
        Date endDate = calendar.getTime();

        ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256WithRSA").build(pair.getPrivate());
        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, pair.getPublic());

        return new JcaX509CertificateConverter().getCertificate(certBuilder.build(contentSigner));
    }

}