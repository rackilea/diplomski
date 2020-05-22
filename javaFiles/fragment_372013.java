import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File random = new File("/dev/random");
        File audio = new File("/dev/dsp");

        InputStream in = new FileInputStream(random);
        OutputStream out = new FileOutputStream(audio);

        while (true) {
            out.write(in.read());
        }
    }
}