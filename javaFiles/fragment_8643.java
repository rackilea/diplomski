String date1 = "2013/06/06";
String time1 = "08:00 AM";
// You are trying to convert the String "2013/06/06 08:00 AM" to a Date object
// for this you tell the DateFormat that the date string is formatted as
// "yyyy/MM/dd hh:mm a" , so when you parse the String to Date , it is converted to
// a valid and expected Date object.
DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm a"); 
Date date = df.parse(date1+" "+time1);        
System.out.println(date); //Thu Jun 06 08:00:00 IST 2013
// To print "2013-06-06 08:00:00"
// You tell SimpleDateFormat to format the date as ""yyyy-MM-dd hh:mm:ss" while 
//printing
System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));