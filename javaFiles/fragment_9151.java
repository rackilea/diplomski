String s = "150790";

// old code with base range 2000-2099
DateTimeFormatter dtf1 = 
  new DateTimeFormatterBuilder().appendPattern("ddMMyy").toFormatter();
System.out.println(dtf1.parse(s)); // 2090-07-15

// improved code with base range 1935-2034
DateTimeFormatter dtf2 = 
  new DateTimeFormatterBuilder().appendPattern("ddMM")
  .appendValueReduced(
    ChronoField.YEAR, 2, 2, Year.now().getValue() - 80
  ).toFormatter();
System.out.println(dtf2.parse(s)); // 1990-07-15