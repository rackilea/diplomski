import static java.lang.System.exit;
import java.util.Scanner;

public class calc {

    public static void main(String args[]) {
        int a, b, ans = 0;
        char c;
        System.out.println("Enter the first Integer");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the second Integer");
        b = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the operation sign");
        c = scan.nextLine().charAt(0);
        if (c == '+')
            ans = a + b;
        else if (c == '-')
            ans = a - b;
        else if (c == '*')
            ans = a * b;
        else if (c == '/')
            ans = a / b;
        else if (c == '%')
            ans = a % b;
        else {
            System.out.println("Wrong operation");
            exit(0);
        }
        System.out.println("The result is " + ans);
    }
}

Output:
Enter the first Integer
10
Enter the second Integer
20
Enter the operation sign
+
The result is 30