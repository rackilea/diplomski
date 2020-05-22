try {
    ProcessBuilder pb = new ProcessBuilder("java.exe", "testfile");
    pb.directory(new File("C:\Users\sg552\Desktop"));
    pb.redirectError();
    Process p = pb.start();
    InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
    consumer.start();
    p.waitFor();
    consumer.join();
} catch (IOException | InterruptedException ex) {
    ex.printStackTrace();
}

//...

public class InputStreamConsumer extends Thread {

    private InputStream is;
    private IOException exp;

    public InputStreamConsumer(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        int in = -1;
        try {
            while ((in = is.read()) != -1) {
                System.out.println((char)in);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            exp = ex;
        }
    }

    public IOException getException() {
        return exp;
    }
}