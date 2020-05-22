public class JavaApplication40 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                // starting at 1 and counting by 2 is always odd
                for (int i = 1; i < 10000; i += 2)
                    System.out.println("odd " + i);
            }
        });
        t.start();

        // starting at 0 and counting by 2 is always even
        for (int x = 0; x < 10000; x+=2)
             System.out.println("even " + x);       
    }
}