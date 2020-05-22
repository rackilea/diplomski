ChronoFormatter<java.util.Date> f =
      ChronoFormatter.ofPattern(
          "dd.MM.uuuu, h:mm BBBB",
          PatternType.CLDR,
          Locale.GERMAN,
          Moment.axis(TemporalType.JAVA_UTIL_DATE))
      .withStdTimezone();
 System.out.println(f.format(new java.util.Date()));