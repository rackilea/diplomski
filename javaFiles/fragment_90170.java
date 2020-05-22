import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.X509CertificateHolder;

import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509CheckKeyUsage {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("DST_X3_CA.pem"); // for example
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);

        // check with simple JCA methods

        boolean [] keyUsageBools = cert.getKeyUsage();
        final int KEY_CERT_SIGN = 5;
        final int CRL_SIGN = 6;
        boolean usagesVerified = keyUsageBools[KEY_CERT_SIGN] && keyUsageBools[CRL_SIGN];
        System.out.println("key usage bits verified? " + usagesVerified);

        // Convert the jca x.509 cert to a bouncycastle x.509 cert, in two steps

        org.bouncycastle.asn1.x509.Certificate bcCert = org.bouncycastle.asn1.x509.Certificate
                .getInstance(ASN1Primitive.fromByteArray(cert.getEncoded())); // step 1
        X509CertificateHolder bcX509Cert = new X509CertificateHolder(bcCert); // step 2

        // now verify keyUsage bits

        final int requiredKeyUsageBits = KeyUsage.keyCertSign | KeyUsage.cRLSign;
        usagesVerified = KeyUsage.fromExtensions(bcX509Cert.getExtensions()).hasUsages(requiredKeyUsageBits);
        System.out.println("key usage bits verified? " + usagesVerified);
    }
}