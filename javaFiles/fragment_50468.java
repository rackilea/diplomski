import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Test040 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = new GregorianCalendar();
        c.add(Calendar.YEAR, 56);
        c.add(Calendar.MONTH, 8);
        c.getTime();
        System.out.println(sdf.format(c.getTime()));
    }

}