public int getWeeksOfMonth(int year, int month, int weekStart) { 
    Calendar calendar = Calendar.getInstance();  
    calendar.set(Calendar.MONTH, month-1);
    calendar.set(Calendar.YEAR, year);
    calendar.setFirstDayOfWeek(weekStart);
    int numOfWeeksInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH); 

    return numOfWeeksInMonth;
}