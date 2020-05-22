Date date; // your date
// Choose time zone in which you want to interpret your Date
Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
cal.setTime(date);
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day = cal.get(Calendar.DAY_OF_MONTH);
// etc.