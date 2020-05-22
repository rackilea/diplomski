import java.util.*;
import java.io.*;

public class ProcessRunner {
    public static void main(String[] args) {
        try {
            int n = 1234;
            Process p = Runtime.getRuntime().exec("python test.py " + n);
            Scanner s = new Scanner(p.getInputStream());
            System.out.println(s.next());
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}