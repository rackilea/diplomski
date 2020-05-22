while (!weekday.isAfter(end)) { // Modify HERE
    System.out.println(weekday);
    dateList.add(weekday);

    if (weekday.getDayOfWeek() == DateTimeConstants.FRIDAY)
        weekday = weekday.plusDays(3);
    else
        weekday = weekday.plusDays(1);
}