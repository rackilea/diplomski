private static int getFirstDayOfWeek(int year,int month,int week){
    return getFirstLastDayOfWeek(true,year,month,week);
}

private static int getLastDayOfWeek(int year,int month,int week){
    return getFirstLastDayOfWeek(false,year,month,week);
}

private static int getFirstLastDayOfWeek(boolean first, int year,int month,int week){
    int exit = 0;
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(Calendar.WEEK_OF_YEAR, week);
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month-1);
    if (!first)
        calendar.add(Calendar.DAY_OF_MONTH, 6);
    // 1st day of the week
    Date date = calendar.getTime();
    // The month and the day of the 1st day of the week
    int theMonth = Integer.valueOf( getInstance().getStrDate(date,"MM") );

    if (theMonth!=month)
        exit = (first?1:new GregorianCalendar(year, month-1, 1).getActualMaximum(Calendar.DAY_OF_MONTH));
    else
        exit = Integer.valueOf( getInstance().getStrDate(date,"d") );
    return exit;
}