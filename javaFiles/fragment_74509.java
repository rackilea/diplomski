// parse dates
DateTimeFormatter f = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
DateTime start = f.parseDateTime("29/09/2017 12:01");
DateTime end = f.parseDateTime("29/09/2017 16:31");
// calculate difference
Period diff = new Period(start, end);

String differenceToString = "Hours: " + diff.getHours() + " Minutes: " + diff.getMinutes() + " Seconds: " + diff.getSeconds();
System.out.println(differenceToString);