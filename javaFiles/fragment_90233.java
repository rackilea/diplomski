Moment ls = PlainTimestamp.of(2016, 12, 31, 23, 59, 59).atUTC().plus(1, SI.SECONDS);
System.out.println(ls); // 2016-12-31T23:59:60Z
ChronoFormatter<Moment> f =
    ChronoFormatter.ofMomentPattern(
        "uuuu-DDD'T'HH:mm:ssX", PatternType.CLDR, Locale.ROOT, ZonalOffset.UTC);
String text = f.format(ls);
System.out.println(text); // 2016-366T23:59:60Z
Moment parsed = f.parse(text);
System.out.println(parsed.isSimultaneous(ls)); // true