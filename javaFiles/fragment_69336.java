public class Tills extends Thread {
private final Buffer buff;
private final int foodId;
private final int tillId;

public Tills(int tillId, int foodId, Buffer buff) {
    this.tillId = tillId;
    this.foodId = foodId;
    this.buff = buff;
}

public void run(){
    while(FastFood.startOrders < FastFood.totalOrders){
        FastFood.semTills.down();

        while(buff.isFull()){
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Tills.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FastFood.startOrders++;
        Order v = new Order(foodId, tillId);
        buff.insert(v);
        System.out.println("Till number " + tillId + " created a new order " + foodId + " to be processed");
        FastFood.semWorker.up();

    }
}
}