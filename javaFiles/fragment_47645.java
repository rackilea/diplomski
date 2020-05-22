import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;


public class DateQuestion {

    public static List<DateTime> getDateRange(DateTime start, DateTime end) {

        List<DateTime> ret = new ArrayList<DateTime>();
        DateTime tmp = start;
        while(tmp.isBefore(end) || tmp.equals(end)) {
            ret.add(tmp);
            tmp = tmp.plusDays(1);
        }
        return ret;
    }

    public static void main(String[] args) {

        DateTime start = DateTime.parse("2012-1-1");
        System.out.println("Start: " + start);

        DateTime end = DateTime.parse("2012-12-31");
        System.out.println("End: " + end);

        List<DateTime> between = getDateRange(start, end);
        for (DateTime d : between) {
            System.out.println(" " + d);
        }
    }
}