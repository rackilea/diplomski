import java.util.*;
import org.joda.time.*;

class Test {
    public static void main(String... args) {
        DateTime now = new DateTime();
        List<Interval> list = splitDuration(now, now.plusSeconds(10), 3, 3 * 1000);

        for(Interval i : list) {
            System.out.println(i.getStart() + " - " +
                               i.getEnd() + " - " +
                               i.toDurationMillis());
        }
    }

    static List<Interval> splitDuration(DateTime start, DateTime end, long chunkAmount, long chunkSize) {
        long millis = start.getMillis();
        List<Interval> list = new ArrayList<Interval>();

        for(int i = 0; i < chunkAmount; ++i) {
            list.add(new Interval(millis, millis += chunkSize));
        }

        list.add(new Interval(millis, end.getMillis()));
        return list;
    }
}