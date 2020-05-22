import java.util.ArrayList;
import java.util.Scanner;

public class AAA {

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> phone = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your name: ");
            name.add(sc.next());
            System.out.println("Please enter your number: ");
            phone.add(sc.nextInt());
        }
    }
}