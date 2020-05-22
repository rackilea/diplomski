import java.util.concurrent.atomic.AtomicInteger;

public class TestClient {

    public static void main(String[] args) {

        ProducerConsumerUtilClass pcuc=new ProducerConsumerUtilClass();

        Thread producer1= new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        pcuc.produce();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            }
        });

Thread producer2= new Thread(new Runnable() {

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        pcuc.produce();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            }
        });
Thread producer3= new Thread(new Runnable() {

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                pcuc.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
});


Thread consumer1= new Thread(new Runnable() {

@Override
public void run() {
    while(true) {
        try {
            Thread.sleep(1000);
            pcuc.consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
});

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();



    }

}

 class ProducerConsumerUtilClass {

    Object obj= new Object();
    private volatile boolean  available;
    private AtomicInteger atomicInteger=null;

    public ProducerConsumerUtilClass() {
        this.available = false;;
        this.atomicInteger = new AtomicInteger(0);;
    }

    public void produce() {
        synchronized (obj) {
                while(available) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                System.out.println("Produce By "+Thread.currentThread().getName()+"Value "+atomicInteger.getAndIncrement());
                this.available=true;
                obj.notifyAll();
        }

    }   

    public void consume() {
        synchronized (obj) {
                while(!available) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                System.out.println("Consume By "+Thread.currentThread().getName()+"Value "+atomicInteger.getAndIncrement());
                this.available=false;
                obj.notifyAll();
        }

    }   


}