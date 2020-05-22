public static Date getSleepingTimes(Date wakingTime, int hoursToSleep, int minutesToSleep) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime( wakingTime );
    calendar.add(Calendar.HOUR,-hoursToSleep);
    calendar.add(Calendar.MINUTE,-minutesToSleep);

    return calendar.getTime();

}