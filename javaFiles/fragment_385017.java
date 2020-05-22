LocalDate startDate = LocalDate.of(2018, 9, 1);
LocalDate endDate = LocalDate.of(2018, 11, 10);

List<LocalDate> firstDays = new ArrayList<>();
List<LocalDate> lastDays = new ArrayList<>();

LocalDate firstOfMonth = startDate.withDayOfMonth(1);
LocalDate lastOfMonth = startDate.withDayOfMonth(startDate.lengthOfMonth());

while (firstOfMonth.isBefore(endDate)) {
    firstDays.add(firstOfMonth.isBefore(startDate) ? startDate : firstOfMonth);
    lastDays.add(endDate.isBefore(lastOfMonth) ? endDate : lastOfMonth);

    firstOfMonth = firstOfMonth.plus(1, ChronoUnit.MONTHS);
    lastOfMonth = firstOfMonth.withDayOfMonth(firstOfMonth.lengthOfMonth());
}

System.out.println(firstDays);
System.out.println(lastDays);