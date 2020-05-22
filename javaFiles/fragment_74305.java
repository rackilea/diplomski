public class Test {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
            if (i % 20 == 0) {
                System.out.print("\r                    \r");
            }
            System.out.flush();
            Thread.sleep(100);
        }
    }
}