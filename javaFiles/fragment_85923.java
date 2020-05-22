public int countDays(Set<String> months, int year) {
    int count = 0;
    for (String month : months) {
        int days = monthMap.get(month);
        if (month.equals(Months.FEBRUARY)) {
            days = computeDaysInFebruary(year);
        }
        count += days;
    }
    return count;
}