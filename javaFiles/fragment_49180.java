import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;

import javax.crypto.KeyAgreement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.*;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

public class Main {

    public static byte[] ecKeyBytesFromDERKey(byte[] ourPk) {
        ASN1Sequence sequence = DERSequence.getInstance(ourPk);
        DERBitString subjectPublicKey = (DERBitString) sequence.getObjectAt(1);
        return subjectPublicKey.getBytes();
    }

    private static PublicKey publicKeyFromEC(byte[] ecKeyByteArray) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("EC", "BC");
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECNamedCurveSpec params = new ECNamedCurveSpec("secp256r1", spec.getCurve(), spec.getG(), spec.getN());
        ECPoint publicPoint = ECPointUtil.decodePoint(params.getCurve(), ecKeyByteArray);
        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(publicPoint, params);
        return kf.generatePublic(pubKeySpec);
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
        kpg.initialize(256);
        KeyPair kp = kpg.generateKeyPair();
        byte[] ourPk = kp.getPublic().getEncoded();
        byte[] ecPublicKey = ecKeyBytesFromDERKey(ourPk);
        System.out.println("our ec public key (65 bytes): " + Hex.encodeHexString(ecPublicKey));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("other public key (65 bytes): ");
        String input = br.readLine();
        br.close();

        byte[] otherPk = Hex.decodeHex(input);
        PublicKey otherPublicKey = publicKeyFromEC(otherPk);

        KeyAgreement ka = KeyAgreement.getInstance("ECDH");
        ka.init(kp.getPrivate());
        ka.doPhase(otherPublicKey, true);

        byte[] sharedSecret = ka.generateSecret();
        System.out.println("Shared secret: " + Hex.encodeHexString(sharedSecret));
    }
}