String hourFormat = "yyyy-MM-dd HH";
DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern(hourFormat);
LocalDateTime start = LocalDateTime.parse("2014-02-05 05",hourFormatter);
LocalDateTime end   = LocalDateTime.parse("2016-02-04 05",hourFormatter);

// Duration duration = Duration.between(start, end);
Period period = Period.between(start.toLocalDate(), end.toLocalDate());

System.out.println(
  String.format("Years: %d  Months: %d  Days: %d  Hours: xxx",
  period.getYears(), period.getMonths(), period.getDays())
);