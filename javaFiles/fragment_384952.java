import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleTest  {
   // NOTE: the input num must be positive.
   public static Date subtractWeekdays(Date d, int num) {
      int count = 0;
      Calendar c = Calendar.getInstance();
      c.setTime(d);

      do {
         c.add(Calendar.DAY_OF_YEAR, -1);
         if(isWeekday(c.get(Calendar.DAY_OF_WEEK))) {
            ++count;
         }
      } while(count < num);

      return c.getTime();
   }

   public static boolean isWeekday(int dayOfWeek) {
      return ((dayOfWeek != Calendar.SATURDAY) && (dayOfWeek != Calendar.SUNDAY));
   }

   public static void main(String[] argv) {
      try {
         SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, y");
         Date d = dateFormat.parse("Jan 14, 2013");
         Date d2 = subtractWeekdays(d, 1);
         System.out.println(d2);
      } catch(Exception ex) {}
   }
}