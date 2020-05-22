import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class temp2 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date date;
        String dateformat = "";
        try {
            date = sdf.parse("2012-05-04 00:00:00.0");
            sdf.applyPattern("dd-MMM-yyyy");
            dateformat = sdf.format(date);
            System.err.println(dateformat);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}