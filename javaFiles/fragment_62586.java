public class Parking implements Runnable {
    private Thread thread;
    private String threadName;
    static int parkingLots;

    static {
        parkingLots = 5;
    }

    Parking(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        long restTime = (long) (Math.random() * 2000);
        if (parkingLots > 0) {
            checkparking();
        } else {
            try {
                System.out.println("Car " + threadName + " is waiting");
                Thread.sleep(restTime);
                System.out.println("Car " + threadName + " is checking for free parkinglot");
                checkparking();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void checkparking() {
        if (parkingLots > 0) {
        long restTime = (long) (Math.random() * 2000);
        try {
            parkingLots--;
            System.out.println("Car " + threadName + " stands in the parking lot");
            Thread.sleep(restTime);
        } catch (InterruptedException e) {
        }
        parkingLots++;
        System.out.println(
                "Car " + threadName + " has left parking, it stood there" + ((double) restTime / (double) 1000) + " s");

    } else {
        System.out.println(
                "Car " + threadName + " has left since there is no parking space");
    }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}