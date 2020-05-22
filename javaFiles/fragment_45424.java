import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        System.out.println(TimeZone.getDefault().getDisplayName(TimeZone.getDefault().inDaylightTime(new Date()),TimeZone.SHORT));
    }
}