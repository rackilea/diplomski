import java.io.*;

public class props {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("openssl s_client -connect google.com:443");
        process.getOutputStream().close();
        process.getErrorStream().close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("Waiting for process to terminate ...");
        process.waitFor();
        System.out.println("Exiting ...");
    }
};