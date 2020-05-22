import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessWithInput {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("cat");
        OutputStream os = p.getOutputStream();
        os.write("Hello World".getBytes());
        os.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
        p.waitFor();
        p.destroy();
    }
}