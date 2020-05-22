public class EvenOddPrinter {
    static boolean flag = true;

    public static void main(String[] args) {
        class Odd implements Runnable {

            @Override
            public void run() {
                for (int i = 1; i <= 10;) {
                    if (EvenOddPrinter.flag) {
                        System.out.println(i + "--->odd");
                        i += 2;
                        EvenOddPrinter.flag = !EvenOddPrinter.flag;
                    }
                }
            }

        }

        class Even implements Runnable {

            @Override
            public void run() {
                for (int i = 2; i <= 10;) {
                    if (!EvenOddPrinter.flag) {
                        System.out.println(i + "---->even");
                        i += 2;
                        EvenOddPrinter.flag = !EvenOddPrinter.flag;
                    }
                }

            }

        }
        Runnable odd = new Even();
        Runnable even = new Odd();
        Thread t1 = new Thread(odd, "Odd");
        Thread t2 = new Thread(even, "Even");
        t1.start();
        t2.start();
    }
}