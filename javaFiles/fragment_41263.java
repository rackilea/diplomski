/**
 * 
 */
package testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author The Elite Gentleman
 *
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            String dateStr = "2010-06-14 02:21:49-0400";
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
            TimeZone tz = TimeZone.getDefault();
            sdf.setTimeZone(tz);
            Date date = sdf.parse(dateStr);

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String newDateStr = sdf.format(date);

            System.out.println(newDateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}