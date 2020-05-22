SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy h:mma", Locale.US);
inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC");
Date date = inputFormat.parse(date + " " + time);

// Or whatever format you want...
SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
outputFormat.setTimeZone(targetTimeZone);
String outputText = outputFormat.format(date);