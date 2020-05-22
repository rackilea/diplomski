import java.util.Scanner;

public class ScratchJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv en rad text: ");
        String input = sc.nextLine();
        String intermediate = input.replaceAll("([bcdfghjklmnpqrstvwxz])", "$1o$1");
        System.out.println(intermediate.replaceAll("([BCDFGHJKLMNPQRSTVWXZ])", "$1X$1"));
    }
}