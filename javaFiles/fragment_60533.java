public static Date getSleepingTimes(Date wakingTime) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime( wakingTime );
    calendar.add(Calendar.HOUR,-7);
    calendar.add(Calendar.MINUTE,-30);

    return calendar.getTime();

}