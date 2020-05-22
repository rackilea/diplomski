final long loopDuration = 1;//second
final long totalSize = 100000;
final long timeInterval = 10;
final AtomicLong batchNumber = new AtomicLong((long)Math.ceil((double) timeInterval / loopDuration));
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        //insert logic
        if (batchNumber.decrementAndGet() == 0) {
            timer.cancel();
            timer.purge();
        }

    }
}, 0, loopDuration * 1000);