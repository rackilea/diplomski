import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class SignatureTest {

    public static void main(String[] args) throws CertificateException, InvalidKeyException, SignatureException, NoSuchAlgorithmException, IOException {
        byte[] certificateAsByteArray = ...;
        byte[] dataToVerifyAsByteArray = ...;
        byte[] signatureHashAsByteArray = ...;

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        InputStream in = new ByteArrayInputStream(certificateBytes);
        X509Certificate x509Certificate = (X509Certificate) certFactory.generateCertificate(in);

        Signature signature = Signature.getInstance("SHA256withECDSA");

        signature.initVerify(x509Certificate.getPublicKey());

        signature.update(dataToVerifyAsHexaString);

        byte[] rBytes = Arrays.copyOfRange(signatureHash, 0, 32);
        byte[] sBytes = Arrays.copyOfRange(signatureHash, 32, 64);

        ASN1Integer asn1R = new ASN1Integer(rBytes);
        ASN1Integer asn1S = new ASN1Integer(sBytes);

        DERSequence seq = new DERSequence(new ASN1Integer[] {asn1R, asn1S});

        boolean isSignatureOK = signature.verify(seq.getEncoded());

        System.out.println("The signature is " + (isSignatureOK ? "" : "NOT ") + "VALID");
    }
}