import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

class Strings {

    private static final int MIN_STRING_LENGTH = 4;

    public static void main(String[] args) throws IOException {
        for (String arg : args) {
            File f = new File(arg);
            if (!f.exists()) {
                System.err.printf("error: no such file or directory: %s%n", arg);
                continue;
            }
            if (!f.canRead()) {
                System.err.printf("error: permission denied: %s%n", arg);
                continue;
            }
            if (f.isDirectory()) {
                System.err.printf("error: path is directory: %s%n", arg);
                continue;
            }
            try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));
                        ByteArrayOutputStream os = new ByteArrayOutputStream()) {
                for (int b = is.read(); b != -1; b = is.read()) {
                    if (b >= 0x20 && b < 0x7F) {
                        os.write(b);
                    } else {
                        if (os.size() >= MIN_STRING_LENGTH) {
                            System.out.println(new String(os.toByteArray(), "US-ASCII"));
                        }
                        os.reset();
                    }
                }
                if (os.size() >= MIN_STRING_LENGTH) {
                    System.out.println(new String(os.toByteArray(), "US-ASCII"));
                }
            }
        }
    }
}