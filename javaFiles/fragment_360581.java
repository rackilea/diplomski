Date d1,d2 = null; // need these for formatting
SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");

String dateStart = "01/01/2022 05:30";
String dateStop = "02/2/2017 06:31";            
d1 = format.parse(dateStart);
d2 = format.parse(dateStop);

DateTime jodaStartTime=new DateTime(d1);
DateTime jodaEndTime=new DateTime(d2);

int startingYear = jodaStartTime.getYear();
int endYear = jodaEndTime.getYear();