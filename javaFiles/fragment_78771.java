public class Person implements Runnable {

    private GasPump pump;
    private Cashier cashier;
    private boolean hasPumped, hasShopped, readyToPump, readyToShop;
    private Thread thread;

    public void run() {
        thread = Thread.getCurrentThread();
        while(!hasPumped && !hasShopped) {
            try {
                readyToPump = false;
                readyToShop = false;
                if (!hasPumped)
                    pumpGas();
                if(!hasShopped)
                    buyCoffee();
                thread.sleep(FOREVER);
            } catch (InterruptedException ex) {
                // check flags to see what to do next
            }
        }
    }

    public void pumpGas() {
        pump.addCarToQueue(this);
    }

    public void buyCoffee() {
        cashier.addCustomerToQueue(this);
    }

    public void setReadyToPump() {
        readyToPump = true;
        thread.interrupt();
    }

    public void setReadyToShop() {
        readyToShop = true;
        thread.interrupt();
    }
}

public class GasPump implements Runnable {

    private BlockingQueue<Person> cars = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (gasStation.isOpen()) {
            Person person = cars.take();
            person.setReadyToPump();
        }
        // clean up persons in queue
    }
}

public class Cashier implements Runnable {

    private BlockingQueue<Person> customers = new LinkedBlockingQueue();
    @Override
    public void run() {
        while(coffeeHouse.isOpen()){
            Person person = customers.take();
            person.setReadyToShop();
        }
        // clean up persons in queue
    }
}