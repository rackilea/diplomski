import java.util.Scanner;

public class NumberFromUser {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(", *");

        int sum = 0;

        for (String token : tokens) {
            sum += Integer.valueOf(token);
        }

        System.out.println(sum);
    }

}