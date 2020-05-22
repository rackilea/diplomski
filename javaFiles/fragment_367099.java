ChronoFormatter<CalendarWeek> cf =
        ChronoFormatter.ofPattern(
            "YYYYww",
            PatternType.CLDR,
            Locale.ROOT,
            CalendarWeek.chronology()
        );
    CalendarWeek cw = cf.parse("201501");
    System.out.println(cw); // 2015-W01
    System.out.println(cw.at(Weekday.MONDAY)); // 2014-12-29