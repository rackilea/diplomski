import java.util.Formatter;

public class TestHex {

    public static final void main(String[]  args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        byte[] testbytes = {-127, 4, 64, -4};

        for (int i=0; i<testbytes.length; i++) {
            byte b = testbytes[i];
            System.out.printf("%s\t%s\n", formatter.format("%02x", b), Integer.toHexString(b & 0xff));
            sb.setLength(0);
        }
    }
}