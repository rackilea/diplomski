import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PBDemo {

    public static void main(String[] args) throws Exception {
        String s;
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        pb.directory(new File("C:\\ljava"));
        pb.redirectError();
        try {
            Process pro = pb.start();
            InputConsumer ic = new InputConsumer(pro.getInputStream());
            System.out.println("...Waiting");
            int exitCode = pro.waitFor();

            ic.join();

            System.out.println("Process exited with " + exitCode);

        } catch (Exception e) {
            System.out.println("sorry" + e);
        }
    }

    public static class InputConsumer extends Thread {

        private InputStream is;

        public InputConsumer(InputStream is) {
            this.is = is;
            start();
        }

        @Override
        public void run() {
//            This is acutally a bad idea, not all process will write a new line ;)
//            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));

            try {
                int in = -1;
                while ((in = is.read()) != -1) {
                    System.out.print((char) in);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

}