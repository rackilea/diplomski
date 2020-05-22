String date1 = "Apr 2010";
String date2 = "Jan 2009";

DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM yyyy");

DateTime d1 = formatter.parseDateTime(date1);
DateTime d2 = formatter.parseDateTime(date2);

Months monthsBetween = Months.monthsBetween(d1, d2);
System.out.println("Months diff: " + monthsBetween.get(DurationFieldType.months()));
Years yearsBetween = Years.yearsBetween(d1, d2);
System.out.println("Years diff: " + yearsBetween.get(DurationFieldType.years()));