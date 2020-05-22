Period period = new Period(new LocalDate(2013, 4, 11), LocalDate.now());
PeriodFormatter formatter = PeriodFormat.wordBased(Locale.GERMANY);
System.out.println(formatter.print(period)); // output: 1 Jahr, 2 Monate und 3 Wochen

formatter = formatter.withLocale(Locale.ENGLISH);
System.out.println(formatter.print(period)); // output: 1 Jahr, 2 Monate und 3 Wochen (bug???)

formatter = PeriodFormat.wordBased(Locale.ENGLISH);
System.out.println(formatter.print(period)); // output: 1 year, 2 months and 3 weeks