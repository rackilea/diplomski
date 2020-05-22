import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestRunJar {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "-jar", "/../maltparser-1.8.jar"});
            pb.inheritIO();
            pb.redirectError();
            pb.directory(new File("/..")); // Path to where maltparser-1.8.jar resides
            Process ps = pb.start();

            InputStreamConsumer stdout = new InputStreamConsumer(ps.getInputStream());
            InputStreamConsumer stderr = new InputStreamConsumer(ps.getErrorStream());

            stderr.start();
            stdout.start();

            stderr.join();
            stderr.join();

            System.out.println("Command exited with: " + ps.waitFor());
        } catch (IOException | InterruptedException exp) {
            exp.printStackTrace();
        }
    }

    public static class InputStreamConsumer extends Thread {

        private InputStream is;
        private IOException exp;
        private StringBuilder output;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            int in = -1;
            output = new StringBuilder(64);
            try {
                while ((in = is.read()) != -1) {
                    output.append((char) in);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                exp = ex;
            }
        }

        public StringBuilder getOutput() {
            return output;
        }

        public IOException getException() {
            return exp;
        }
    }

}