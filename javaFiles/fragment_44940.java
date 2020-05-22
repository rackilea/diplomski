final Timer timer = new Timer();

final TimerTask task = new TimerTask() {

    @Override
    public void run() {
        System.out.println("timer task");
        timer.cancel(); // stop timer after execution
    }
};

timer.schedule(task, 1000); // schedule task with delay of 1000ms