public class User implements Runnable {

    private final String name;
    private final CyclicBarrier cb;

    public User(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(name+" user started !!!! ");
        try {
            cb.await(1,TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        System.out.println(name+" user ended !!!! ");
    }
}


public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5);

        User user1 = new User("USER1", barrier);
        new Thread(user1).start();

        User user2 = new User("USER2", barrier);
        new Thread(user2).start();


        //Expected users are 5, but only 2 user threads started so far 
        // and resetting below which should throw barrier broken exception
        Thread.sleep(100);
//        barrier.reset();
        Thread.sleep(1100);
        if(barrier.isBroken()) {
            System.out.println("Barrier broken ");
        }
    }
}