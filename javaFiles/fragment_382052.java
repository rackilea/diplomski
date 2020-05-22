import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec(
                "java trafficcircle.Street 1 2");

        BufferedReader br = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}