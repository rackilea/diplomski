DateTime from = new DateTime(2014, DateTimeConstants.FEBRUARY, 15, 8, 51, 30, 100);
DateTime to = new DateTime(2016, DateTimeConstants.DECEMBER, 25, 17, 01, 51, 50);

Interval i = new Interval(from, to);
Period p = i.toPeriod(PeriodType.yearMonthDayTime());

System.out.println(p.getYears() + " years");
System.out.println(p.getMonths() + " months");
System.out.println(p.getDays() + " days");
System.out.println(p.getHours() + " hours");
System.out.println(p.getSeconds() + " seconds");
System.out.println(p.getMillis() + " millis");