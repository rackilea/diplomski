public class TimerCallback {

    Timer tim;
    private long period;
    private Numbers numbers;

    public TimerCallback(Numbers numbers, long period) {
        tim = new Timer(true);
        this.period = period;
        this.numbers = numbers;
    }

    public void start() {
        tim.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                TimerCallback.this.numbers.tick();
            }
        }, new Date(), period);
    }

}