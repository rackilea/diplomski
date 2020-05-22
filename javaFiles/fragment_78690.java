public long computeDateTimeMillisUTC(long dateMillisUTC, int hour24,
        int minute, TimeZone zone) {
    Calendar cal = Calendar.getInstance(zone);

    cal.setTimeInMillis(dateMillisUTC);
    cal.set(Calendar.HOUR_OF_DAY, hour24);
    cal.set(Calendar.MINUTE, minute);

    return cal.getTimeInMillis();
}