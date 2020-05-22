import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

/**
* mcopy
*/
public class mcopy {
    private static DecimalFormat format = new DecimalFormat("#.#");
    private final static int SMALL = 512;
    private final static int MEDIUM = 512 * 1024;
    private final static int LARGE = 1024 * 1024;
    private final static int XLARGE = 2 * 1024 * 1024;


    private static void copy(File a, File b, byte[] buffer) {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            double j = 0;
            double length = a.length();
            fin = new FileInputStream(a);
            fout = new FileOutputStream(b);

            int i;
            while(-1 != (i = fin.read(buffer))) {
                j += i;
                fout.write(buffer, 0, i);
                System.out.print("Copying... " + format.format(((j / length) * 100)) + " " + a.getName() + " to "
                    + b.getPath() + " buffer: " + buffer.length + " \r");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File in = new File(args[0]);
        File out = new File(args[1]);
        double ld = in.length();
        double l = ld / 1024 / 1024;

        byte[] buffer = null;

        if (l <= ((9 * 1024) / 1024 / 1024)) {
            buffer = new byte[SMALL];
        } else if (l <= 9) {
            buffer = new byte[MEDIUM];
        } else if (l <= 99) {
            buffer = new byte[LARGE];
        } else {
            buffer = new byte[XLARGE];
        }
        copy(in, out, buffer);
        System.out.println();
    }
}