// Get "now"
Calendar cal = Calendar.getInstance();

// Update to most recent "first day of week",  e.g. SUNDAY in the U.S., MONDAY in France
int firstDayOfWeek = cal.getFirstDayOfWeek();
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
if (dayOfWeek < firstDayOfWeek)
    dayOfWeek += 7;
cal.add(Calendar.DAY_OF_MONTH, firstDayOfWeek - dayOfWeek);

// Remove time fields
int year  = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day   = cal.get(Calendar.DAY_OF_MONTH);
cal.clear();
cal.set(year, month, day);

// Get a Timestamp for use with PreparedStatement
Timestamp startDate = new Timestamp(cal.getTimeInMillis());