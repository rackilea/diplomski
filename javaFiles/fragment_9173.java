public void gameStart() {
    DisplayPat();
    getpattern();
    schedule(3); //start the timer task
}

Timer timer = new Timer(); //timer object

public void schedule(int seconds) {
    timer.schedule(new ScheduleTask(), seconds*1000);
}

class ScheduleTask extends TimerTask {
    public void run() {
        System.out.format("Time completed, invoke setup");
        InputGame.setup();
        timer.cancel(); //Terminate Timer thread
    }
}