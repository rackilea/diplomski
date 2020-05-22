import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DLSequence;

public class RsaAsn1Example {
// ...
    public static BigInteger [] parseASN1RsaPublicKey(byte [] encoded) throws IOException {
        ASN1InputStream asn1_is = new ASN1InputStream(encoded);
        DLSequence dlSeq = (DLSequence) asn1_is.readObject();
        ASN1Integer asn1_n = (ASN1Integer) dlSeq.getObjectAt(0);
        ASN1Integer asn1_e = (ASN1Integer) dlSeq.getObjectAt(1);
        asn1_is.close();
        return new BigInteger[]{ asn1_n.getPositiveValue(), asn1_e.getPositiveValue()};
    }
// ....
}