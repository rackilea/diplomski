import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CallPython {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("python", "/path/to/your/script.py", "10");
        Process p = pb.start();

        char[] readBuffer = new char[1000];
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            int n = br.read(readBuffer);
            if (n <= 0)
                break;
            System.out.print(new String(readBuffer, 0, n));
        }
    }
}