public class Timer extends Thread {
    private Thread thread;
    private boolean running;
    private boolean paused;
    private int ping;

    public Time(int ping){
        this.ping = ping;
        running = false;
        paused = true;
    }

    private void loop(){
        while(running){
            if(paused){
                tick();//check at the end
            }
            delay(ping);
        }
    }

    private void delay(int mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
        }
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }else{
            paused = false;
        }
    }

    public void pause(){
        paused = true;
    }

    public void reset(){
        thread = null;
        running = false;
        paused = true;
    }

    @Override
    public void run() {
        running = true;
        paused = false;
        loop();
    }
}