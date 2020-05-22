import java.*;
import java.util.*;
import java.text.*;

public class StringApp {
    public static void main(String[] args)
    {
        String oldDate = "2011-05-23 6:05:00";
        String dateFormat = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Calendar cl = Calendar.getInstance();
            cl.setTime(sdf.parse(oldDate));
            String newDate = sdf.format(cl.getTime());
            System.out.println(newDate);
        } 
        catch (ParseException ex) { 
        }
    }
}