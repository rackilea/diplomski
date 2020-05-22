ChronoFormatter<Moment> cf = 
    ChronoFormatter.ofMomentPattern("uuuu-MM-dd'T'HH:mm:ssXXX'['VV']'", PatternType.CLDR, Locale.ROOT, ZonalOffset.UTC);
System.out.println(cf.with(Leniency.STRICT).parse("2015-06-17T12:55:33+05:00[Europe/Amsterdam]"));
// Exception in thread "main" java.text.ParseException: Ambivalent offset information: AMSTERDAM versus +05:00

// this alternative formatter can be used as workaround for strict parsing
ZonedDateTime zdt = 
  ZonalDateTime.parse(
    "2015-06-17T12:55:33+05:00[Europe/Amsterdam]", 
    cf.with(Leniency.STRICT)
  ).toTemporalAccessor();