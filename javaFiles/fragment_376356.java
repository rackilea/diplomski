public Calendar getCalendar(int day, int month, int year) {
    Calendar date = Calendar.getInstance();
    date.set(Calendar.YEAR, year);

    // We will have to increment the month field by 1

    date.set(Calendar.MONTH, month+1);

    // As the month indexing starts with 0

    date.set(Calendar.DAY_OF_MONTH, day);

    return date;
}