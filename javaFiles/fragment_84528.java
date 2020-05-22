Calendar aCalendar = Calendar.getInstance();
// add -1 month to current month
aCalendar.add(Calendar.MONTH, -1);
// set DATE to 1, so first date of previous month
aCalendar.set(Calendar.DATE, 1);

Date firstDateOfPreviousMonth = aCalendar.getTime();

// set actual maximum date of previous month
aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//read it
Date lastDateOfPreviousMonth = aCalendar.getTime();