List<Employee> list = ...

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("MM-yyyy")
    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
    .toFormatter();
list.removeIf(e -> LocalDate.parse(e.getHiringDate(), formatter)
    .until(LocalDate.parse(e.getTerminationDate(), formatter)).getMonths() < 3);