//configuration
ULocale locale = new ULocale("@calendar=persian");
Calendar calendar = Calendar.getInstance(locale);
calendar.setFirstDayOfWeek(7); //Make Saturdays first day of the week.

//usage
calendar.setTime(new Date());
int year = calendar.get(Calendar.YEAR);
int weekOfYear = (calendar.get(Calendar.YEAR_WOY) == year)? calendar.get(Calendar.WEEK_OF_YEAR) : 53;
int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);