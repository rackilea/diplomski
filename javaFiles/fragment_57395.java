PeriodFormatter yearsAndMonths = new PeriodFormatterBuilder()
     .appendSeparator("PT")
     .appendHours()
     .appendSeparator("H")
     .appendMinutes()
     .appendSeparator("M")
     .toFormatter();