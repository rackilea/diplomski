Calendar calendar = Calendar.getInstance();
ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
scheduler.scheduleAtFixedRate(new MyTask(), millisToNextHour(calendar), 60*60*1000, TimeUnit.MILLISECONDS);



private static long millisToNextHour(Calendar calendar) {
    int minutes = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);
    int millis = calendar.get(Calendar.MILLISECOND);
    int minutesToNextHour = 60 - minutes;
    int secondsToNextHour = 60 - seconds;
    int millisToNextHour = 1000 - millis;
    return minutesToNextHour*60*1000 + secondsToNextHour*1000 + millisToNextHour;
}