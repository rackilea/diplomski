public void RestartTimer() {

    ttimer.cancel();
    timer.cancel();
    timer = new Timer();
    TimerTask ttimer = new TimerTask() {
        public void run() {
        System.out.println("ping");
        }   
    };

    timer.scheduleAtFixedRate(ttimer, 10000, 10000);
}