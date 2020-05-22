import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class FormatsTest {

 public void testParse() throws ParseException {
  DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss.SSS Z");
  formatter.setTimeZone(TimeZone.getDefault());
  formatter.setLenient(false);
  System.out.println(formatter.format(new Date()));

  formatter.parse(formatter.format(new Date()));
 }

 public static void main(String[] args) throws Exception {
   FormatsTest test = new FormatsTest();
   test.testParse();
 }

}