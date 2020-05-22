// says "foo" every half second
Timer t = new Timer();
t.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        System.out.println("foo");
    }
}, 0, 500);