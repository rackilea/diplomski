String text = "2014-04-24T08:51:58.213567Z";
// You could just hard code the length, but this feels easier to read
String trimmed = text.substring(0, "yyyy-MM-ddTHH:mm:ss.SSS".length());
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
format.setTimeZone(TimeZone.getTimeZone("Etc/UTC");
Date date = format.parse(trimmed);