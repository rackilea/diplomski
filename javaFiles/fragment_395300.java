DateTimeFormatter f = new DateTimeFormatterBuilder()
  .appendPattern("ddyyyy")
  .parseDefaulting(MONTH_OF_YEAR, 1)
  .toFormatter();
LocalDate date = LocalDate.parse("141968", f);
System.out.println(date.getDayOfMonth());
System.out.println(date.getYear());