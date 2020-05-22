Calendar calendar = Calendar.getInstance();

if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    Calendar noticeDisplayTime = Calendar.getInstance();
    noticeDisplayTime.setTimeInMillis(prefs.getLong("noticeDisplayTime", 0));

    if (!(calendar.get(Calendar.DAY_OF_YEAR) == noticeDisplayTime.get(Calendar.DAY_OF_YEAR) &&
        calendar.get(Calendar.YEAR) == noticeDisplayTime.get(Calendar.YEAR)) {
        prefs.edit().putLong("noticeDisplayTime", calendar.getTimeInMillis()).apply();
        // Display the notice
    }
}