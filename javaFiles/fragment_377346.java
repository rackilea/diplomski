public static Date addDays(Date date, int days) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, days);
    Log.d("TEST", "BEFORE CHECKING: " + cal.getTime().toString());
    // SATURDAY is the last day of week so add 2 days
    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
        cal.add(Calendar.DATE, 2);
        // SUNDAY is the first day of week so add 1 day
    } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        cal.add(Calendar.DATE, 1);
    } // else not required as it means its one of the week day
    Log.d("TEST", "AFTER UPDATING: " + cal.getTime().toString());
    return cal.getTime();
}