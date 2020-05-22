class ScheduleTimer {

    public TextView textView;

    private Timer dateTimer;

    private Timer remainderTimer;

    private Date formatDate = new Date();

    private Date nextDate;

    private boolean remainderTimerStarted;

    private static final long REMINDER_UPDATE_INTERVAL = 1000;

    private static String[] DATES;

    private int currentIndex;

    private Activity activity;

    public ScheduleTimer(final TextView t, Activity a) {
        textView = t;
        activity = a;
        dateTimer = new Timer();
    }

    public void main(String[] dates) throws ParseException {
        checkDates(dates);
        run();
    }

    private void checkDates(String[] dates) throws ParseException {
        List<String> list = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
        for(String date : dates) {
            long current = System.currentTimeMillis() + 1000;
            if(format.parse(date).getTime() - current > 0) {
                list.add(date);
            }
        }
        DATES = new String[list.size()];
        list.toArray(DATES);
    }

    private void run() {
        nextDate = parseDate(DATES[currentIndex]);
        schedule();
    }

    public void schedule() {
        runSecondsCounter();
        dateTimer.schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println("Current date is:" + new Date());
                currentIndex++;
                if (currentIndex < DATES.length) {
                    nextDate = parseDate(DATES[currentIndex]);
                    System.out.println("Next date is:" + nextDate);
                    schedule();
                } else {
                    remainderTimer.cancel();
                }
            }
        }, nextDate);

    }

    private Date parseDate(String nextDate) {
        Date date = null;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm",
                Locale.ENGLISH);
        try {
            date = format.parse(nextDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private void runSecondsCounter() {
        if (remainderTimerStarted) {
            remainderTimer.cancel();
        }

        remainderTimer = new Timer();
        remainderTimer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                remainderTimerStarted = true;
                long remains = nextDate.getTime() - new Date().getTime();
                System.out.println("Remains: " + (remains / 1000) + " seconds");
                formatDate.setTime(remains);

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(formatDate.toString());
                    }
                });

            }
        }, REMINDER_UPDATE_INTERVAL, REMINDER_UPDATE_INTERVAL);
    }
}