use the following code to convert into the required format

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateconversion {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String maxDate = "15012009";
        SimpleDateFormat fromFormat = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat toFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = null;
        try {
            date = fromFormat.parse(maxDate);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("formated date:-" + toFormat.format(date));
    }
}