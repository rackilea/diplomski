public class Worker extends Thread{
private final int workerId;
private final Buffer buff;


public Worker(int workerId, Buffer buff) {
    this.workerId = workerId;
    this.buff = buff;
}

 public void run() {
    while (FastFood.totalOrders > FastFood.processedOrders) {
        FastFood.semWorker.down();
        while (buff.isEmpty()) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //FastFood.processedOrders++;
        System.out.println("Worker: " + workerId + " completed order number " + buff.remove() + " total orders processed so far: " + FastFood.processedOrders++);

        FastFood.semTills.up();
        try {
            Random n = new Random();
            int time = n.nextInt(100) + 1;
            sleep(time);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
 }
}