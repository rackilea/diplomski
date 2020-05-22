public int countDayOccurence(int year, int month,int dayToFindCount) {
    Calendar calendar = Calendar.getInstance();
    // Note that month is 0-based in calendar, bizarrely.
    calendar.set(year, month - 1, 1);
    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    int count = 0;
    for (int day = 1; day <= daysInMonth; day++) {
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == dayToFindCount) {
            count++;
            // Or do whatever you need to with the result.
        }
    }
    return count;
}