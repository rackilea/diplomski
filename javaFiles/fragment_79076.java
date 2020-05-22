Locale ukraine = new Locale("en", "UA"); // or use new Locale("en", "001") for worldwide
TZID winZone = WindowsZone.of("FLE Standard Time").resolveSmart(ukraine);
PlainTime currentTime = SystemClock.inZonalView(winZone).now().toTime();
System.out.println(currentTime); // T12:02:40,344

// truncate seconds and nanoseconds
currentTime = currentTime.with(PlainTime.PRECISION, ClockUnit.MINUTES);
System.out.println(currentTime); // T12:02

// format in am/pm-notation
ChronoFormatter<PlainTime> f1 =
    ChronoFormatter.ofTimePattern("h:mm a", PatternType.CLDR, Locale.US);
String formatted1 = f1.format(currentTime);
System.out.println(formatted1); // 12:02 pm

// or use styled formatter (which has only limited control over displayed precision)
ChronoFormatter<PlainTime> f2 = 
    ChronoFormatter.ofTimeStyle(DisplayMode.SHORT, Locale.US);
String formatted2 = f2.format(currentTime);
System.out.println(formatted2); // 12:02 pm