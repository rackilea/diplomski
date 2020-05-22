public class Child1 implements Runnable {
    Object mutex;

    public Child1(Object mutex){
        this.mutex = mutex;
    }

    public void run() {
        synchronized (mutex) {
            for(int c = 0; c < 10; c++){
                System.out.println(c+1);
            }

            try {
                mutex.wait(); // Changed here
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        for(int c = 20; c < 31; c++){
            System.out.println(c+1);
        }
    }
}