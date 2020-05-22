// The time we want the alert...
String time = "16:00";
// The date String of now...
String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
try {
    // The date + time to give us context
    Date timeAt = sdf.parse(date + " " + time);
    boolean rollOver = false;
    // Determine if the time has already passed, if it has
    // we need to roll the date to the next day...
    if (timeAt.before(new Date())) {
        rollOver = true;
    }
    // A Calendar with which we can manipulate the date/time
    Calendar cal = Calendar.getInstance();
    cal.setTime(timeAt);
    // Skip 15 minutes in advance
    cal.add(Calendar.MINUTE, 15);
    // Do we need to roll over the time...
    if (rollOver) {
        cal.add(Calendar.DATE, 1);
    }
    // The date the alert should be raised
    Date alertTime = cal.getTime();
    System.out.println("Raise alert at " + alertTime);
    // The timer with which we will wait for the alert...
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("duha");
        }
    }, alertTime);
} catch (ParseException ex) {
}