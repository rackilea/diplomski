import java.util.Date;
import java.util.TimeZone;

public class test {

    public static void main(String[] args) {
        System.out.println(TimeZone.getTimeZone("EST").inDaylightTime( new Date() ));
        System.out.println(TimeZone.getTimeZone( "GMT-9:00").inDaylightTime( new Date() ));
    }
}