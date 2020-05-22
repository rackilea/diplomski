Intent calIntent = new Intent(Intent.ACTION_INSERT);
calIntent.setData(Events.CONTENT_URI);
calIntent.putExtra(Events.TITLE, "Google IO Afterparty");
calIntent.putExtra(Events.EVENT_LOCATION, "The W Hotel Bar on Third Street");
calIntent.putExtra(Events.DESCRIPTION, "Hang out after Google IO for a drink and geeky conversation.");
Calendar startTime = Calendar.getInstance();
startTime.set(2012, 5, 29, 18, 0);
Calendar endTime = Calendar.getInstance();
endTime.set(2012, 5, 29, 22, 30);
calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
startTime.getTimeInMillis());
calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
endTime.getTimeInMillis());
startActivity(calIntent);