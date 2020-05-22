import java.util.Scanner;

// This will print what you want but will not make it look bigger as it
// will get printed in console
public class Main {

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
 // we print a heading and make it bigger using HTML formatting
        System.out.println("<h4>--"+num+" --</h4>");

    }
}