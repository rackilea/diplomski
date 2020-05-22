import java.io.*;
public class TP {
    public static void main(String... argv) {
        ProcessBuilder pb = new ProcessBuilder(argv);
        for (int i = 0; i < 4; i++) {
            try {
                Process process = pb.start();
                int result = process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while (reader.ready() || errReader.ready()) {
                    if (reader.ready()) {
                        System.out.println("Process output: " + reader.readLine());
                    }
                    if (errReader.ready()) {
                        System.err.println("Process error: " + errReader.readLine());
                    }
                }
                reader.close();
                errReader.close();
                if (result != 0) {
                    System.err.println("Process returned with result " + result);
                }
                System.out.println("Finished process for iteration " + i);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}