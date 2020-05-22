import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int input=-1;
        while(input<0){
            while (!sc.hasNextInt()) {
                if(sc.hasNext()){
                    String s = sc.next(); /* read things that are not Integers */
                    System.out.println("Invalid input:" + s);
                }
            }
            input = sc.nextInt();
            if(input<0){
                System.out.println("Please input a positive integer.");
            }
        }
        System.out.println("Valid input was "+input);
    }
}