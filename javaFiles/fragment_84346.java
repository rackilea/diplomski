import java.text.*;
import java.util.*;

public class DateIt{
    public static void main(String [] args) throws Exception{
        String dStr= "Wed, 05 Jun 2013 00:48:12 GMT"; 
        SimpleDateFormat ft =  new SimpleDateFormat ("E, dd MMM yyyy HH:mm:ss z"); 
        Date t = ft.parse(dStr); 
        TimeZone gmt = TimeZone.getTimeZone("England/London");
        ft.setTimeZone(gmt);
        System.out.println(t); 
        System.out.println(ft.format(t));
        }
}