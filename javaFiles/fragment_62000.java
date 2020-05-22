public void scheduleTask(int delay){
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            timer.cancel();
            doSomething();
        }
    } , delay, 1);
}