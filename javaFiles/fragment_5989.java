// Adding 3 days
calendar.add(Calendar.DATE, 3);

// Set the Calendar new date as maximum date of date picker
dpd.getDatePicker().setMaxDate(calendar.getTimeInMillis());

// Subtract 6 days from Calendar updated date
calendar.add(Calendar.DATE, -6);

// Subtract 6 months from Calendar updated date
calendar.add(Calendar.MONTH, -6);