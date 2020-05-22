PeriodFormatter fmt = new PeriodFormatterBuilder()
        .printZeroAlways()
        .minimumPrintedDigits(2)
        .appendHours()
        .appendSeparator(":")
        .printZeroAlways()
        .minimumPrintedDigits(2)
        .appendMinutes()
        .appendSeparator(":")
        .printZeroAlways()
        .minimumPrintedDigits(2)
        .appendSeconds()
        .toFormatter();
Period period = new Period(34600);
System.out.println(fmt.print(period));