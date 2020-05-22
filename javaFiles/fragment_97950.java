import java.util.Calendar;
import java.util.GregorianCalendar;
public class MyCal
{

    public static void main( String[] args )
    {
        GregorianCalendar datePast = new GregorianCalendar();
        datePast.add(Calendar.MONTH, -6); // subtract 6 months
        GregorianCalendar datePresent = new GregorianCalendar();
        GregorianCalendar dateFuture = new GregorianCalendar();
        dateFuture.add(Calendar.MONTH, 6); // add 6 months

        System.out.println("compare datePresent to datePast: "+datePresent.compareTo(datePast));
        System.out.println("compare datePresent to datePresent: "+datePresent.compareTo(datePresent));
        System.out.println("compare datePresent to dateFuture: "+datePresent.compareTo(dateFuture));
    }
}