import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignatureFromPython {
    private static final Pattern PAT = Pattern.compile("\\[(\\d+)\\]");

    private static byte[] i2osp(final BigInteger i, final int bitSize) {
        if (i == null || i.signum() == -1) {
            throw new IllegalArgumentException(
                    "input parameter should not be null or negative");
        }

        if (bitSize < Byte.SIZE) {
            throw new IllegalArgumentException(
                    "bitSize parameter should not be negative and a multiple of 8");
        }

        final int byteSize = (bitSize - 1) / Byte.SIZE + 1;
        final byte[] signedBigEndian = i.toByteArray();
        final int signedBigEndianLength = signedBigEndian.length;
        if (signedBigEndianLength == byteSize) {
            return signedBigEndian;
        }

        final byte[] leftPadded = new byte[byteSize];

        if (signedBigEndianLength == byteSize + 1) {
            System.arraycopy(signedBigEndian, 1, leftPadded, 0, byteSize);
        } else if (signedBigEndianLength < byteSize) {
            System.arraycopy(signedBigEndian, 0, leftPadded, byteSize
                    - signedBigEndianLength, signedBigEndianLength);
        } else {
            throw new IllegalArgumentException(
                    "Integer i is too large to fit into " + bitSize + " bits");
        }
        return leftPadded;
    }

    public static String toHex(final byte[] data) {
        final StringBuilder hex = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            hex.append(String.format("%02X", data[i]));
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        String sigString = "[68830459489863257411523011520104203035626147084548742757940226446079486348431212041096334237130703774949375015187747280487790006116898192460644067270457728626039524097117092304115366780581423597886886987279231850120937691165013216970647150989646220735762034864029622135210042186666476516651349805320771941650]";
        Matcher sigMatcher = PAT.matcher(sigString);
        if (!sigMatcher.matches()) {
            throw new IllegalArgumentException("Whatever");
        }
        BigInteger sigBI = new BigInteger(sigMatcher.group(1));
        // requires bouncy castle libraries
        System.out.println(toHex(i2osp(sigBI, 1024)));
    }
}