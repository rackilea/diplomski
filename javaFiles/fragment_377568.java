DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
builder.parseLenient();
builder.append(DateTimeFormatter.ofPattern("yyyyMMdd"));
DateTimeFormatter dtf = builder.toFormatter();
String dubiousDate = "2014-04-01";
LocalDate date = LocalDate.parse(dubiousDate, dtf);
System.out.println(date);