import java.lang.*;
import java.io.*;

public class TestPython {
    public static void main(String[] args) {

        System.out.println("I will run a Python script!");
        Runtime r = Runtime.getRuntime();
        String pyScript = "py/test.py";

        File f = new File(pyScript);
        if (f.exists() && !f.isDirectory()) {
            try {
                Process p = r.exec("python " + pyScript);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
                String line = null;
                while ((line = in .readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("Python script ran!!");
            } catch (Exception ex) {
                System.out.println("Something bad happened!!");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Unexistent file!" + pyScript);
        }
    }
}