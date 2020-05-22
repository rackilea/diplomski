import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateFormatter
{

    public static void main(String args[])
    {

        // Create formatter
        String input = "9:32am";
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("h:mma");
        LocalTime requestedTime = LocalTime.parse(input.toUpperCase(), FOMATTER);
        System.out.printf("Requested time %s is 5 minutes or more  away from now %b", input,
            isRequestedImeMoreThan5MinsAway(requestedTime));
    }

    private static boolean isRequestedImeMoreThan5MinsAway(LocalTime requestedTime)
    {
        return ChronoUnit.MINUTES.between(LocalTime.now(), requestedTime) >= 5;
    }

}