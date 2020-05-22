String inputText = "2010-03-24T17:28:50.000Z";
// "Z" appears not to be supported for some reason.
DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
DateFormat outputFormat = new SimpleDateFormat("EEE. MMM. d. yyyy");
Date parsed = inputFormat.parse(inputText);
String outputText = outputFormat.format(parsed);

// Output is Wed. Mar. 24 2010 on my box