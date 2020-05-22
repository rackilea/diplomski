// Convert input string into a date
DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
Date date = inputFormat.parse(inputString);

// Format date into output format
DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
String outputString = outputFormat.format(date);