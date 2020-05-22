import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SdfFun {
   private static final String PATTERN = "MM/dd";
   private static final SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);

   public static Date getAlphaDate(int month, int day) throws ParseException {
      String tempDate = month + "/" + day;
      return SDF.parse(tempDate);
   }

   public static void main(String[] args) {
      Date date = null;
      try {
         date = getAlphaDate(2, 16);

         System.out.println(SDF.format(date));
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

}