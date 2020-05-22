// Note year/month reversal: try to consistently use larger units first. It
// makes for a cleaner API.
public setDates(int year, int month, TimeZone zone) {
    Calendar calendar = Calendar.getInstance(zone);

    // Do you really want 0-based months, like Java has? Consider month - 1.
    calendar.set(year, month, 1, 0, 0, 0);
    calendar.clear(Calendar.MILLISECOND);
    startDate = calendar.getTime();

    // Get to the last millisecond in the month
    calendar.add(Calendar.MONTH, 1);
    calendar.add(Calendar.MILLISECOND, -1);
    endDate = calendar.getTime();
}