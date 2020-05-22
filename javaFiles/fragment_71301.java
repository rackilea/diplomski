public class PackedDecimal {

    public static byte[] format(long number, int bytes) {
        byte[] b = new byte[bytes];

        final byte minusSign = 0x0D; // Minus
        final byte noSign = 0x0F; // Unsigned

        String s = Long.toString(number);
        int length = s.length();
        boolean isNegative = false;

        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
            length--;
        }

        int extraBytes = length - bytes + 1;

        if (extraBytes < 0) {
            // Pad extra byte positions with zero
            for (int i = 0; i < -extraBytes; i++) {
                b[i] = 0x00;
            }
        } else if (extraBytes > 0) {
            // Truncate the high order digits of the number to fit
            s = s.substring(extraBytes);
            length -= extraBytes;
            extraBytes = 0;
        }

        // Translate the string digits into bytes
        for (int i = 0; i < length; i++) {
            String digit = s.substring(i, i + 1);
            b[i - extraBytes] = Byte.valueOf(digit);
        }

        // Add the sign byte
        if (isNegative) {
            b[bytes - 1] = minusSign;
        } else {
            b[bytes - 1] = noSign;
        }

        return b;
    }

    public static void main(String[] args) {
        long number = -456L;
        byte[] b = PackedDecimal.format(number, 5);
        System.out.println("Number: " + number + ", packed: " + byteToString(b));

        number = 0L;
        b = PackedDecimal.format(number, 5);
        System.out.println("Number: " + number + ", packed: " + byteToString(b));

        number = 5823L;
        b = PackedDecimal.format(number, 5);
        System.out.println("Number: " + number + ", packed: " + byteToString(b));

        number = 123456L;
        b = PackedDecimal.format(number, 5);
        System.out.println("Number: " + number + ", packed: " + byteToString(b));
    }

    public static String byteToString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append("0x");
            sb.append(Integer.toHexString((int) b[i]).toUpperCase());
            sb.append(" ");
        }
        return sb.toString();
    }

}