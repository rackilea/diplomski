import java.util.*;

public class GetDay {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2011, 1, 9); // 1 = Feb  months are zero based remember
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));  
    }
}