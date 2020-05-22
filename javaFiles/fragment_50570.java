import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

Date now = new Date(); // get current time
Calendar c = Calendar.getInstance(); // get Java Calendar instance
c.setTime(now); // set Calendar time to now
c.add(Calendar.MINUTE, 5); // add 5 minutes to current time
Date now_plus_5_minutes = c.getTime(); // get Date value for amended time
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // create a formatter for date       
String mydate = sdf.format(now_plus_5_minutes); // format date as string
vars.put("mydate",mydate); // save date to JMeter variable named "mydate"