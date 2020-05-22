public Date getDateFromTick(long ticks){
    final long TICKS_AT_EPOCH = 621355968000000000L;
    final long TICKS_PER_MILLIS = 10000;

    Date date = new Date((ticks-TICKS_AT_EPOCH)/TICKS_PER_MILLIS);
    Log.v(TAG, "DATE:>> (" + ticks + ") to " + date.toString());

    return date;
}