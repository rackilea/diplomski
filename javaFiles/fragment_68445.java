DateTimeParser[] parsers = { 
  DateTimeFormat.forPattern("MM-dd-yyyy").getParser(),
  DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
  DateTimeFormat.forPattern("MM/dd/yyyy").getParser(),
  DateTimeFormat.forPattern("yyyy/MM/dd").getParser()
};

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
  .append(null, parsers)
  .toFormatter()
  .withZone(DateTimeZone.UTC);

DateTime dttm1 = formatter.parseDateTime("01-31-2012");
DateTime dttm2 = formatter.parseDateTime("01/31/2012");
DateTime dttm3 = formatter.parseDateTime("2012-01-31");