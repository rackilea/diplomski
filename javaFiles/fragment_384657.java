**Update**
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SomeClass {

    public static void main(String[] args) {


         System.out.println(convertStringToTimestamp("2015-06-09 11:51:12,708"));
         //be consistent here with , and .
         System.out.println(convertStringToTimestamp("2015-04-17 11:29:49.564"));
         System.out.println();


    }

    private static Timestamp  convertStringToTimestamp(String something) {


SimpleDateFormat dateFormat = null;
        if(something.contains(".")) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        } 
        if(something.contains(",")) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");
        }
        Timestamp timestamp = null;
            Date parsedDate;
            try {
                parsedDate = dateFormat.parse(something);
                 timestamp = new java.sql.Timestamp(parsedDate.getTime());

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return timestamp;
    }



}