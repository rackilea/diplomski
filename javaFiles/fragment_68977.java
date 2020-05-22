import org.joda.time.DateTime;
import org.joda.time.Period;

...
DateTime dt1 = new DateTime("2004-12-13T21:39:45.618-06:00");
DateTime dt2 = new DateTime("2004-12-13T21:39:45.618-08:00");
Period p = new Period(dt1, dt2);

System.out.println("DAYS: " + p.getDays())
System.out.println("HOURS: " + p.getHours());
System.out.println("MINUTES: " + p.getMinutes());
System.out.println("SECONDS: " + p.getSeconds());