// A formatter that prints the timezone offset
DateTimeFormatter fmt = DateTimeFormat.forPattern("Z");

// The current date+time in the system default timezone.
DateTime dt = new DateTime();

// Create the result.
String result = "/Date(" + dt.getMillis() + fmt.print(dt) + ")/";