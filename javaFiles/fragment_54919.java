public static String convertTimeToHoursMinutesString(Context _context, long lTimeinMillis){
    // Calculate hours first.
    long hours = TimeUnit.MILLISECONDS.toHours(lTimeinMillis);
    lTimeinMillis -= TimeUnit.HOURS.toMillis(hours);
    // Calculate minutes then.
    long minutes = TimeUnit.MILLISECONDS.toMinutes(lTimeinMillis);
    lTimeinMillis -= TimeUnit.MINUTES.toMillis(minutes);
    // Calculate seconds last.
    //long seconds = TimeUnit.MILLISECONDS.toSeconds(lTimeinMillis);

    StringBuilder str = new StringBuilder(64);
    str.append(hours);

    str.append(_context.getString(R.string.Hour));
    str.append(minutes);
    str.append(_context.getString(R.string.Min));
    //str.append(seconds);
    //str.append(" Seconds");
    return(str.toString());
}