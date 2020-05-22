import static java.lang.Integer.*;
import java.util.*;

class t1 {
    static void calc(Scanner in) {

        System.out.print("Operation: ");
        int op = in.nextInt();
        System.out.print("a: ");
        int a = in.nextInt();
        System.out.print("b: ");
        int b = in.nextInt();

        int res = 0;

        switch(op) {
            case 1:
                res = a + b;
                break;
            case 2:
                res = a - b;
                break;
            case 3:
                res = a * b;
                break;
            case 4:
                res = a / b;
                break;
            default:
                System.out.println("Invalid operation");
                System.exit(-1);
        }

        System.out.println(res);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (true) {
            calc(in);
        }
    }
}