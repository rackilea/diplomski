import org.joda.time.*;

public class Test {

    public static void main(String[] args)
    {
        DateTime dt = new DateTime(1285871400000L,
                                   DateTimeZone.UTC);
        System.out.println(dt);
    }
}