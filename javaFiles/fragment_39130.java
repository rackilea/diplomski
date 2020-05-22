PeriodFormatter yearsAndMonths = new PeriodFormatterBuilder()
 .printZeroAlways()
 .appendYears()
 .appendSuffix(" year", " years")
 .appendSeparator(" and ")
 .printZeroRarely()
 .appendMonths()
 .appendSuffix(" month", " months")
 .toFormatter();