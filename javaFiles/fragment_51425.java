import java.util.HashMap;
import java.util.Iterator;

import org.joda.money.Money;
import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vrntmgr.server.utils.StringUtils;

public class TemporalCollectionTest {

TemporalCollection rates;

@Before
public void setup() {
    rates = new TemporalCollection();
    rates.put(new DateMidnight(2010, 1, 1).toDateTime(),
            Money.parse("USD 900"));
    rates.put(new DateMidnight(2010, 2, 1).toDateTime(),
            Money.parse("USD 1000"));
    rates.put(new DateMidnight(2010, 3, 1).toDateTime(),
            Money.parse("USD 2000"));
}

@Test
public void testTemporalRetreival() {
    Interval intrvl = new Interval(new DateMidnight(2010, 1, 15),
            new DateMidnight(2010, 3, 15));

    HashMap<Interval, Object> myMap = rates.getAdjacentIntervals(intrvl);
    // System.out.println(StringUtils.toString(myMap.keySet()));


    Iterator<Interval> it = myMap.keySet().iterator();
    Assert.assertEquals(it.next(),new Interval(new DateMidnight(2010,3,1), new DateMidnight(2010,3,15)));
    Assert.assertEquals(it.next(),new Interval(new DateMidnight(2010,2,1), new DateMidnight(2010,3,1)));
    Assert.assertEquals(it.next(),new Interval(new DateMidnight(2010,1,15), new DateMidnight(2010,2,1)));
}

@Test 
public void testEndDayAfterRange() {


    Interval intrvl = new Interval(new DateMidnight(2010,1,15), new DateMidnight(2010, 2, 1));

    HashMap<Interval, Object> myMap =  rates.getAdjacentIntervals(intrvl);


    Iterator<Interval> it = myMap.keySet().iterator();
    Interval res = it.next();
    Assert.assertEquals(res,new Interval(new DateMidnight(2010,1,15), new DateMidnight(2010,2,1)));

    System.out.println("days are" + Days.daysIn(res));

}


}