import java.util.Scanner;

public class Test {
    public static int getNum(Scanner sc, String desc) {
        System.out.print("Enter the " + desc + " integer --> ");
        return sc.nextInt();
    }

    public static int findLargest(int n1, int n2, int n3, int n4) {
        if (n1 >= n2 && n1 >= n3 && n1 >= n4)
            return n1;
        if (n2 >= n3 && n2 >= n4)
           return n2;
        if (n3 >= n4)
            return n3;
        return n4;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = getNum(scan, "first");
        int b = getNum(scan, "second");
        int c = getNum(scan, "third");
        int d = getNum(scan, "fourth");

        int x = findLargest(a, b, c, d);
        System.out.println("max(" + a + "," + b + "," + c + "," + d + ") = " + x);
    }
}