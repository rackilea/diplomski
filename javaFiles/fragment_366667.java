private static final DateTimeFormatter FORMATTER =
    DateTimeFormat.forPattern("yyyyMMdd'_'HHmmss")
                  .withLocale(Locale.US);
...

// I prefer to be explicit about using "the current time". I prefer to use
// an injectable dependency such as a Clock type, too...
DateTime now = new DateTime(System.currentTimeMillis(), DateTimeZone.UTC);

// Note: this *doesn't* ensure that it's the right day of the week.
// You'd need to think about that separately - it may be as simple as
// scheduling it appropriately... but bear your local time zone in mind!
DateTime end = now.withTimeAtStartOfDay();
DateTime start = end.minusDays(7);

String startText = FORMAT.print(start);
String endText = FORMAT.print(end);