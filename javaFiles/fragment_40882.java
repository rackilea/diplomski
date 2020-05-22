import java.io.*;
import java.util.Arrays;

public class Deserialize {

    // Credit: https://stackoverflow.com/a/140861/398670
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }


    public static void main( String[] args ) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java Deserialize aced....hexstring...");
            System.exit(1);
        }

        String hex = args[0];
        if (hex.startsWith("\\x")) {
            hex = hex.substring(2);
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(hexStringToByteArray(hex));
        ObjectInput in = new ObjectInputStream(bis);
        Object obj_read = in.readObject();

        if (obj_read instanceof int[][]) {
            int[][] obj_arr = (int[][]) obj_read;
            System.err.println("Array contents are: " + Arrays.deepToString(obj_arr) );
        }
    }

}