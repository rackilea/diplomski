public String printPeriod(String from, String to) {
   PeriodFormatter formatter = new PeriodFormatterBuilder()
     .printZeroRarelyFirst()
     .appendYears().appendSuffix(" Years").appendSeparator(",")
     .appendMonths().appendSuffix(" Months").appendSeparator(",")
     .appendWeeks().appendSuffix(" Weeks").appendSeparator(",")
     .appendDays().appendSuffix(" Days").appendSeparator(",")
     .appendHours().appendSuffix(" Hours").appendSeparator(",")
     .appendSeconds().appendSuffix(" Seconds").appendSeparator(",")
     .appendMillis().appendSuffix(" Milliseconds")
   .toFormatter();

   return formatter.print(new Period(new DateTime(DateTimeZone.forID(from)), new DateTime(DateTimeZone.forID(to))));
}