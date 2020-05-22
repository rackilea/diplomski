import java.util.*;
import java.text.*;

public class Test {

    public static void main(String[] args) throws Exception {
      Calendar cal = parseReturnDate("19 AUG 2011");
      System.out.println(cal);
    }

    public static Calendar parseReturnDate(String returnDate) 
        throws ParseException {
      SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
      Date date = formatter.parse(returnDate);
      Calendar cal=Calendar.getInstance();
      cal.setTime(date);
      return cal;
    }       
}