final ThisLocalizedWeek usWeek = new ThisLocalizedWeek(Locale.US);
System.out.println(usWeek);
// The English (United States) week starts on SUNDAY and ends on SATURDAY
System.out.println(usWeek.getFirstDay()); // 2018-01-14
System.out.println(usWeek.getLastDay());  // 2018-01-20

final ThisLocalizedWeek frenchWeek = new ThisLocalizedWeek(Locale.FRANCE);
System.out.println(frenchWeek);
// The French (France) week starts on MONDAY and ends on SUNDAY
System.out.println(frenchWeek.getFirstDay()); // 2018-01-15
System.out.println(frenchWeek.getLastDay());  // 2018-01-21