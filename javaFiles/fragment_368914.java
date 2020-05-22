// put this at the class level of calendarFragment.
Calendar holdTodaysDate = Calendar.getInstance(Locale.getDefault());


_calendar = Calendar.getInstance(Locale.getDefault());
_calendar = holdTodaysDate; // Add this line;
_calendar.add(Calendar.MONTH, position); // Add this line
month = _calendar.get(Calendar.MONTH) + 1;
year = _calendar.get(Calendar.YEAR);