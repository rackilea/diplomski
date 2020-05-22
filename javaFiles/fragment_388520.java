final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
    final Calendar thatDay = new GregorianCalendar(2014, 11, 25);
    final Calendar today = Calendar.getInstance();
    service.schedule(new Runnable() {

        @Override
        public void run() {
            long diff = thatDay.getTimeInMillis() - today.getTimeInMillis();
            long diffSec = diff / 1000;
            long days = diffSec / SECONDS_IN_A_DAY;
            long secondsDay = diffSec % SECONDS_IN_A_DAY;
            long seconds = secondsDay % 60;
            long minutes = (secondsDay / 60) % 60;
            long hours = (secondsDay / 3600); // % 24 not needed
            if (diff > 0) {
                ses2.schedule(this, 1, TimeUnit.SECONDS);
            }
        }
    }, 1, TimeUnit.SECONDS);