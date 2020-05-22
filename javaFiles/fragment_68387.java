package folder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner skaner = new Scanner(System.in);

while (skaner.hasNext()){
    String x = skaner.next();
    try {
        int y = Integer.parseInt(x);
        System.out.println("That is an integer " + y);
    }
    catch(NumberFormatException e) {
        System.out.println("That is a string " + x);
        }
    }
    skaner.close();
    }
}