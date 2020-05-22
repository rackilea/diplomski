import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(
                        "C:\\Users\\shane\\Downloads\\PSTools\\PsExec.exe",
                        "\\\\builder",
                        "-u",
                        "xxx",
                        "-p",
                        "xxx",
                        "cmd", 
                        "/c", "dir", "c:\\"
        );
        try {
            Process p = pb.start();
            StreamConsumer.consume(p.getErrorStream());
            StreamConsumer.consume(p.getInputStream());
            System.out.println("Exited with :" + p.waitFor());
        } catch (IOException | InterruptedException exp) {
            exp.printStackTrace();
        }
    }

    public static class StreamConsumer implements Runnable {

        private InputStream is;

        public StreamConsumer(InputStream is) {
            this.is = is;
        }

        public static void consume(InputStream is) {
            StreamConsumer consumer = new StreamConsumer(is);
            new Thread(consumer).start();
        }

        @Override
        public void run() {
            try {
                int in = -1;
                while ((in = is.read()) != -1) {
                    System.out.print((char)in);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

}