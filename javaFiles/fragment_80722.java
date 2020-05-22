import java.util.Scanner;

class Test {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        System.out.println("  " + t);
        for (int i = 1; i <= t; i++) {

            System.out.println("Enter size of set : ");
            int n = obj.nextInt();
            System.out.println("Enter yout set : ");
            int a = obj.nextInt();
            int b = obj.nextInt();
            if (n > 2)
                for (int j = 2; j <= n; j++) {
                    int c = obj.nextInt();
                    if (c < a) {
                        b = a;
                        a = c;
                    } else {
                        if (c < b) {
                            b = c;
                        }
                    }
                }
            System.out.println(a + b);
            System.out.println("=====================");
        }
        obj.close();
    }
}