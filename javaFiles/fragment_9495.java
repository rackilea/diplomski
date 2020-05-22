SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
String decodedDate = URLDecoder.decode("2025-08-08T15%3A41%3A46", "UTF-8");
Date date = dateParser.parse(decodedDate);

//Decode the given date and convert to Date object

SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z-07:00 yyyy", Locale.US);
sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

System.out.println(sdf.format(date)); // set the timezone and print in the desired format