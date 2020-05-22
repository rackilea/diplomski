SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM");

// from date to string
String dateString = dateFormatter.format(new Date()); 

// and back
Date date = dateFormatter.parse(dateString);