import java.util.Date;
public class Test {
    public static void main(final String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Executing command " + i + ": " + (new Date()));
            try {
                final Process p = new ProcessBuilder("sh", "-c", "sleep 2;").redirectErrorStream(true).start();
                p.waitFor();
            } catch (final Throwable t) {
                t.printStackTrace();
            }
        }
    }
}