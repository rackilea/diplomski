public void timer() {

    TimerTask tasknew = new MyTask();
    Timer timer = new Timer();

    /* scheduling the task, the first argument is the task you will be 
     performing, the second is the delay, and the last is the period. */
    timer.schedule(tasknew, 100, 100);
}