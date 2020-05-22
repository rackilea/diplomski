public class JarRunner {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\JCcc.jar");
        pb.directory(new File("C:\\"));
        try {
            Process p = pb.start();
            LogStreamReader lsr = new LogStreamReader(p.getInputStream());
            Thread thread = new Thread(lsr, "LogStreamReader");
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LogStreamReader implements Runnable {

    private BufferedReader reader;

    public LogStreamReader(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}