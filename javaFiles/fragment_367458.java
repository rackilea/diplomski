import java.util.*;
import java.io.*;

public class ProcessRunner {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("python test.py");
            Scanner s = new Scanner(p.getInputStream());
            PrintWriter toChild = new PrintWriter(p.getOutputStream());

            toChild.println("1234");    // write to child's stdin
            toChild.close();            // or you can use toChild.flush()
            System.out.println(s.next());
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}