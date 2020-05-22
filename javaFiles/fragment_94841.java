import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;

int number = 123;
ASN1ObjectIdentifier oid = new ASN1ObjectIdentifier("1.2.3.4.5.6.7.8.9"); // some arbitrary non-existent OID number
DERSequence seq = new DERSequence(new ASN1Encodable[] { oid, new ASN1Integer(number) });

ArrayList<GeneralName> namesList = new ArrayList<>();
namesList.add(new GeneralName(GeneralName.otherName, seq));
GeneralNames subjectAltNames = GeneralNames.getInstance(new DERSequence((GeneralName[]) namesList.toArray(new GeneralName[] {})));

// certBuilder is a X509v3CertificateBuilder
certBuilder.addExtension(Extension.subjectAlternativeName, false, subjectAltNames);