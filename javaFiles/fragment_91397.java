import java.util.Scanner;
import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("c:/lol.txt"));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            // get String array from line
            String[] strarr = line.split(" "); // attention: split expect regular expression, not just delimiter!
            // initialize array
            int[] intarr = new int[strarr.length];
            // convert each element to integer
            for (int i = 0; i < strarr.length; i++) {
                intarr[i] = Integer.valueOf(strarr[i]); // <= update array from new line
            }
        }
    }
}