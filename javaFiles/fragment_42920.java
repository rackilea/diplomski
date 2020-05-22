public boolean isFirstDayofMonth(Calendar calendar){
    if (calendar == null) {
        throw new IllegalArgumentException("Calendar cannot be null.");
    }

    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    return dayOfMonth == 1;
}