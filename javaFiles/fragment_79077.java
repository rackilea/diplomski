Map<Meridiem, String> map = new EnumMap<>(Meridiem.class);
map.put(Meridiem.AM, "AM");
map.put(Meridiem.PM, "PM");
ChronoFormatter<PlainTime> f3 =
    ChronoFormatter
        .setUp(PlainTime.axis(), Locale.ROOT)
        .addPattern("h:mm ", PatternType.CLDR)
        .addText(PlainTime.AM_PM_OF_DAY, map)
        .build();
String formatted3 = f3.format(currentTime);
System.out.println(formatted3); // 12:02 PM