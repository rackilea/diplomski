public class EchoTestDrive {
    public static void main(String[] args) {
        Echo e1 = new Echo();
        Echo e2 = new Echo();

        int x = 0;
        while (x < 4) {
            e1.hello();
            e1.count = e1.count + 1;
            System.out.println("e1.count = " + e1.count);
            if (x == 3) {
                e2.count = e2.count + 1;
                System.out.println("x == 3 e2.count = " + e2.count);
            }
            if (x > 0) {
                e2.count = e2.count + e1.count;
                System.out.println("x > 0 e2.count = " + e2.count);
            }

            x = x + 1;
        }
        System.out.println(e2.count);
    }
}