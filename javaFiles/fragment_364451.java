String shortPattern =
    DateTimeFormatterBuilder.getLocalizedDateTimePattern(
        FormatStyle.SHORT,
        null,
        IsoChronology.INSTANCE,
        Locale.forLanguageTag("sqi-AL")
    );
System.out.println(shortPattern); //y-MM-d