package com.company;

public class Service {

    private Timer timer;
    Timer.TickListener tickListener = new Timer.TickListener() {
        @Override
        public void onTick(Timer timer) {
            // this gets called perfectly fine
            System.out.println(42);
        }
    };

    Service() {
        // more to follow in code snippets below where I demonstrate the issue I am facing
        timer = new Timer();
        timer.setTickListener(tickListener);
    }

    private static class Timer
            implements Runnable {

        private interface TickListener {
            void onTick(Timer timer);
        }

        private TickListener tickListener;

        public void setTickListener(TickListener tickListener) {
            this.tickListener = tickListener;
        }

        public void start() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            while(true) {
                if(tickListener != null) {
                    // to verify that Timer is actually running
                    // and tickListener is not null
                    // I actually log here
                    // and the log appears just fine in all cases

                    tickListener.onTick(this);
                }
                try{
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void foo() {
        timer.start();
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.foo();
    }
}