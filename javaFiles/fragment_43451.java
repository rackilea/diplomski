String[] parts = new String[]{temp.substring(0, temp.indexOf('-')), temp.substring(temp.indexOf('-') + 1)};
long millis = Long.parseLong(parts[0]);
parts[1] = parts[1].replaceAll("^0*(\\-?[0-9]*)$", "$1");
int timeZone = Integer.parseInt(parts[1]);

int rawOffset = (timeZone / 100) * 3600000 + (timeZone % 100);

GregorianCalendar cal = new GregorianCalendar();
cal.setTimeInMillis(millis);
cal.setTimeZone(new SimpleTimeZone(rawOffset, "GMT"));