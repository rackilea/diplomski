//Here is my formatter
DateTimeFormat Format = DateTimeFormat.getFormat("MM/dd/yyyy");

//Here is my timestamp - SHOULD BE AUGUST 16TH, 2010
String date = "1281966439000";

//Here is where I create the date, and format it
long longDate = Long.parseLong(date);
Date eventDate = new Date(longDate);
String eventDateFinal = Format.format(eventDate);

//In this alert, I get 1/15/1970
Window.alert(eventFinal);