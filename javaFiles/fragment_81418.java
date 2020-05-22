// millis value
long millis = 1498499869249L;

// get the date in system default timezone
LocalDate dt = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
// check if it's equals to today
System.out.println(dt.equals(LocalDate.now(ZoneId.systemDefault())));