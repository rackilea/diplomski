SimpleDateFormat sdfHour = new SimpleDateFormat("HH");
SimpleDateFormat sdfMinute = new SimpleDateFormat("mm");
SimpleDateFormat sdfSecond = new SimpleDateFormat("ss");

Date now = new Date();

String string_hours = sdfHour.format(now);
String string_minutes = sdfMinute.format(now);
String string_seconds = sdfSecond.format(now);