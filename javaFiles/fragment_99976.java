public static long round(long millis , TimeUnit unit){
    Calendar calendar = Calendar.getInstance();
    switch(unit){
        case DAYS:
            calendar.set(Calendar.HOUR, 0);
        case HOURS:
            calendar.set(Calendar.MINUTE, 0);
        case MINUTES:
            calendar.set(Calendar.SECOND, 0);
        case SECONDS:
        case MILLISECONDS:
        default:
            calendar.set(Calendar.MILLISECOND, 0);
    }
    return calendar.getTimeInMillis();
}