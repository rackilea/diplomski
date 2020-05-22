public static BlockingQueue blockingQueue = new ArrayBlockingQueue<Integer>(10);

public static void main(String[] args) {
    Thread t1 = new Thread(()-> {
        while(true){
            Random random = new Random();
            try {
                int i = random.nextInt(10);
                if(i!=8) { // a car request parking space
                    System.out.println("waiting until parking available");
                    int j = (int) blockingQueue.take();
                    System.out.println("released parking space "+j+" to requested car " );
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });
    Thread t2 = new Thread(()->{
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            Random random = new Random();
            try {
                int i = random.nextInt(10);
                if(i!=5) { //car went out from parking space .add avilable slot to queue
                    System.out.println("add  free parking space:" + i +" to queue");
                    blockingQueue.put(i);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    t1.start();
    t2.start();

}