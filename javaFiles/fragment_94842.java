import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

X509Certificate cert = // a java.security.cert.X509Certificate
byte[] v = cert.getExtensionValue(Extension.subjectAlternativeName.getId());
GeneralNames gn = GeneralNames.getInstance(X509ExtensionUtil.fromExtensionValue(v));
GeneralName[] names = gn.getNames();
for (GeneralName name : names) {
    if (name.getTagNo() == GeneralName.otherName) {
        ASN1Sequence seq = ASN1Sequence.getInstance(name.getName());
        if ("1.2.3.4.5.6.7.8.9".equals(oid.getId())) { // OID is the arbitrary one I created
            ASN1Integer value = (ASN1Integer) seq.getObjectAt(1);
            int number = value.getValue().intValue();
            System.out.println(number); // number is 123
        }
    }
}