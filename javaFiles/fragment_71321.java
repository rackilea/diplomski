public class FirstCircleRepaintThread extends Thread{

    private volatile boolean keepRunning = true;

    public static final long SPEED_OF_ROTATING = 25L;

    public void kull() {

        keepRunning = false;
        interrupt();
        try {
            join();
        } catch (InterruptedException ex) {
        }

    }

    @Override
    public void run(){
        //while(true){

            MainCycle.frame.panel.startAngleFirst = 34;
            int i = 0;
            Random r = new Random();

            while(keepRunning){