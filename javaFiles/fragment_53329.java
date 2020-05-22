public class ThreadTest {

public static void main(String[] args) {
    for(int i =0; i< 9; i++) {
        final int finalI = i;
        new Thread(()->{
            try {
                Thread.sleep(1000); // assuming a delay for some operations
                System.out.println(Thread.currentThread().getName()+" "+finalI);
                //System.out.println(Thread.currentThread().getName()+" "+ i); // can't do this.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start(); 

    }
}
}