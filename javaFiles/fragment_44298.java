DateTime currentDate = new DateTime();
DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY HH:mm").withLocale(locale);
String formatedDate = dtf.print(currentDate);
System.out.println(formatedDate);
DateTime now = dtf.parseDateTime(formatedDate);
System.out.println(now);