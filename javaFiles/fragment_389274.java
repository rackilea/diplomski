LocalDate startDate = new LocalDate(2011, 11, 8);
LocalDate endDate = new LocalDate(2012, 5, 1);

LocalDate thisMonday = startDate.withDayOfWeek(DateTimeConstants.MONDAY);

if (startDate.isAfter(thisMonday)) {
    startDate = thisMonday.plusWeeks(1); // start on next monday
} else {
    startDate = thisMonday; // start on this monday
}

while (startDate.isBefore(endDate)) {
    System.out.println(startDate);
    startDate = startDate.plusWeeks(1);
}