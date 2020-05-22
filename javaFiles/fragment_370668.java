DateTime birthDate = new DateTime(1978, 3, 26, 12, 35, 0, 0);
DateTime now = new DateTime();
Period elapsed = new Period(birthDate, now);

PeriodFormatter formatter = new PeriodFormatterBuilder()
    .appendYears().appendSuffix(" years, ")
    .appendMonths().appendSuffix(" months, ")
    .appendDays().appendSuffix(" days, ")
    .appendHours().appendSuffix(" hours, ")
    .appendMinutes().appendSuffix(" minutes, ")
    .appendSeconds().appendSuffix(" seconds")
    .toFormatter();

System.out.println(formatter.print(elapsed));