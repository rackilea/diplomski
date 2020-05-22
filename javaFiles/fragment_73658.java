import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class TimSortDateAndTimestampTest {

    // the same test data with all Dates, all Timestamps, all Strings or all Longs does NOT fail.
    // only fails with mixed Timestamp and Date objects
    @Test
    public void testSortWithTimestampsAndDatesFails() throws Exception {
        List<Date> dates = new ArrayList<>();
        dates.add(new Timestamp(1498621254602L));
        dates.add(new Timestamp(1498621254603L));
        dates.add(new Timestamp(1498621254603L));
        dates.add(new Timestamp(1498621254604L));
        dates.add(new Timestamp(1498621254604L));
        dates.add(new Timestamp(1498621254605L));
        dates.add(new Timestamp(1498621254605L));
        dates.add(new Timestamp(1498621254605L));
        dates.add(new Timestamp(1498621254605L));
        dates.add(new Timestamp(1498621254606L));
        dates.add(new Timestamp(1498621254607L));
        dates.add(new Date(1498621254605L));
        dates.add(new Timestamp(1498621254607L));
        dates.add(new Timestamp(1498621254609L));
        dates.add(new Date(1498621254603L));
        dates.add(new Date(1498621254604L));
        dates.add(new Date(1498621254605L));
        dates.add(new Date(1498621254605L));
        dates.add(new Date(1498621254607L));
        dates.add(new Timestamp(1498621254607L));
        dates.add(new Date(1498621254608L));
        dates.add(new Timestamp(1498621254608L));
        dates.add(new Date(1498621254611L));
        dates.add(new Timestamp(1498621254612L));
        dates.add(new Timestamp(1498621254613L));
        dates.add(new Date(1498621254607L));
        dates.add(new Timestamp(1498621254607L));
        dates.add(new Timestamp(1498621254608L));
        dates.add(new Timestamp(1498621254609L));
        dates.add(new Timestamp(1498621254611L));
        dates.add(new Date(1498621254603L));
        dates.add(new Date(1498621254606L));

        for (int i = 0; i < 200; i++) {
            Collections.shuffle(dates);
            Collections.sort(dates);
        }
    }
}