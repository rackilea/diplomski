import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ASN1InputStream;
.
.
.
.
byte[] UID =  cert.getExtensionValue("2.5.29.32");

DERObject derObject = toDERObject(UID);

if (derObject instanceof DEROctetString)
{
    DEROctetString derOctetString = (DEROctetString)derObject;
    derObject = toDERObject(derOctetString.getOctets());

}
System.out.println(derObject.toString());