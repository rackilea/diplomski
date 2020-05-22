import java.util.*;

public class CaseTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter(" "); //separate entries with a space
        String input;
        while (sc.hasNext()) {
            input = sc.next();
            try {
                double num = Double.parseDouble(input);
                System.out.println("" + Math.pow(num, 2));
            } catch (NumberFormatException e) {
                //input was not a number so move to the next "test"
            }
            try {
                URL test = new URL(input);
                System.out.println("Valid URL");
            } catch (MalformedURLException e) {
                //input was not a valid URL so move to the next "test"
            }
            //put more tests here if you want
        }
        sc.close();
    }
}