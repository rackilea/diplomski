public static int hoursAgo(String datetime) {
    Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).parse(datetime); // Parse into Date object
    Date now = Calendar.getInstance().getTime(); // Get time now
    long differenceInMillis = now.getTime() - date.getTime();
    long differenceInHours = (differenceInMillis) / 1000L / 60L / 60L; // Divide by millis/sec, secs/min, mins/hr
    return (int)differenceInHours;
}