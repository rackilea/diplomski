import java.text.*;
import java.util.*;

DateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy hh:mm:ss a z");
Calendar sunday = new GregorianCalendar();

sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // Set day of week to Sunday.

System.out.println(dateFormat.format(sunday.getTime()));

sunday.add(Calendar.DAY_OF_YEAR, 7); // Add seven days.

System.out.println(dateFormat.format(sunday.getTime()));