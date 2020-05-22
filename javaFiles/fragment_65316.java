public class QuadCorePi extends Thread {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        QuadCorePi thread1 = new QuadCorePi();
        thread1.begin = 0 ;
        thread1.end = numSteps / 4 ;

        QuadCorePi thread2 = new QuadCorePi();
        thread2.begin = numSteps / 4 ;
        thread2.end =  numSteps  / 2 ;

        QuadCorePi thread3 = new QuadCorePi();
        thread3.begin = numSteps / 2 ;
        thread3.end = 3 * numSteps / 4 ;

        QuadCorePi thread4 = new QuadCorePi();
        thread4.begin = 3 * numSteps / 4 ;
        thread4.end = numSteps ;

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        long endTime = System.currentTimeMillis();

        double pi = step * (thread1.sum + thread2.sum + thread3.sum + thread4.sum) ;

        System.out.println("Value of pi: " + pi);

        System.out.println("Calculated in " +
                (endTime - startTime) + " milliseconds");
    }

    static int numSteps = 10000000;

    static double step = 1.0 / (double) numSteps;

    double sum ;
    int begin, end ;

    public void run() {

        sum = 0.0 ;

        for(int i = begin ; i < end ; i++){
            double x = (i + 0.5) * step ;
            sum += 4.0 / (1.0 + x * x);
        }
    }
}