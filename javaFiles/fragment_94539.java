private static long getStartTime(String startTime) {
    int hour = Integer.parseInt(startTime.split(":")[0]);
    int minutes = Integer.parseInt(startTime.split(":")[1]); 
    Calendar cal = Calendar.getInstance();
    Date dateNow = cal.getTime();
    cal.set(Calendar.HOUR_OF_DAY, hour);
    cal.set(Calendar.MINUTE, minutes);
    cal.set(Calendar.SECOND, 0);

    if(cal.getTime().before(dateNow)) {
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        return cal.getTime().getTime();
    } else {
        return cal.getTime().getTime();
    }
}