public class Main {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Worker w1 = new Worker("Worker 1", sharedData);
        Worker w2 = new Worker("Worker 2", sharedData);

        w1.start();
        w2.start();

        while (true) {
            try {
                Thread.sleep(1000);
                sharedData.increase();;
                System.out.println("Master: " + sharedData.value());
                synchronized (Main.class) {
                    Main.class.notifyAll();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

class SharedData {
    private int data = 0;

    public void increase () {
        data++;
    }

    public int value() {
        return data;
    }

}

class Worker extends Thread {
    private String workerName;
    private SharedData sharedData;

    public Worker(String workerName, SharedData sharedData) {
        super();
        this.workerName = workerName;
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (Main.class) {
                    Main.class.wait();
                }
                System.out.println(workerName + ": " + sharedData.value());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}