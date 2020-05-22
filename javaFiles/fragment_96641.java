import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.joda.time.DateMidnight;
import org.joda.time.Period;
import org.junit.Test;

public class DateTimePeriodTest {

    @Test
    public void period1ShouldHaveNoWeeks() {
        final Period period = new Period(new DateMidnight(2013, 5, 27), new DateMidnight(2013, 6, 28));
        assertThat(period.getMonths(), is(1));
        assertThat(period.getWeeks(), is(0));
        assertThat(period.getDays(), is(1));
    }

    @Test
    public void period2ShouldHaveFourWeeks() {
        final Period period = new Period(new DateMidnight(2013, 5, 27), new DateMidnight(2013, 7, 26));
        assertThat(period.getMonths(), is(1));
        assertThat(period.getWeeks(), is(4));
        assertThat(period.getDays(), is(1));
    }
}