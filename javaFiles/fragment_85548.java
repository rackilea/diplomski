import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;

public class RsaJavaToDotNet {


    private static BigInteger b64ToBigInteger(String b64) {
        byte [] bigEndianBytes = DatatypeConverter.parseBase64Binary(b64);
        return new BigInteger(1, bigEndianBytes); 
    }

    /**
     * @param args base64 encoded .NET big-endian integer arrays
     *    args[0] = modulus
     *    args[1] = prime
     *    args[2] = decrypt exponent
     *    args[3] = encrypt exponent
     *    args[4] = cipher
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        BigInteger modulus = b64ToBigInteger(args[0]);
        final int modulusByteLength = (modulus.bitLength() + 7) / 8;
        BigInteger prime = b64ToBigInteger(args[1]);
        BigInteger d = b64ToBigInteger(args[2]);
        BigInteger e = b64ToBigInteger(args[3]);
        BigInteger cipherInt = b64ToBigInteger(args[4]);

        // Decrypt the cipher

        BigInteger plainInt = cipherInt.modPow(d, modulus);
        byte [] plain = plainInt.toByteArray();

        // Verify the format and extract the message.

        if (plain.length != (modulusByteLength - 1) || plain[0] != 2) {
            throw new Exception("Something is wrong");
        }

        // Find the zero byte delimited the payload from the padding

        int zeroPos = 1;
        while (zeroPos < plain.length && plain[zeroPos] != 0) {
            ++zeroPos;
        }

        String plainStr = new String(plain, zeroPos + 1, plain.length - zeroPos - 1, "UTF-8");
        System.out.println(plainStr);
    }

}