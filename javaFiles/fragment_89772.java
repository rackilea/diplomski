import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class Schedule {

// figure out some way to Store these values in a database
static List<DateTime[]> schedule = new ArrayList<DateTime[]>();

//Number of hours in a day
static DateTime startDay = new DateTime(2013, 03, 12, 8, 0, 0);
static DateTime endDay = new DateTime(2013, 03, 12, 16, 0, 0);

//Create a Period from the start and End Day dates
static Period dayPeriod = new Period(startDay, endDay);

public static void main(String[] args) {

    // These events will be created on your UI
    DateTime[] firstEvent = { new DateTime(2013, 03, 12, 9, 0, 0), new DateTime(2013, 03, 12, 10, 0, 0) };
    DateTime[] secEvent = { new DateTime(2013, 03, 12, 11, 0, 0), new DateTime(2013, 03, 12, 12, 0, 0) };
    DateTime[] thirdEvent = { new DateTime(2013, 03, 12, 12, 0, 0), new DateTime(2013, 03, 12, 13, 0, 0) };

    //print the hours left, before creating events
    System.out.println(dayPeriod.getHours() + " : " + dayPeriod.getMinutes() + " : " + dayPeriod.getSeconds());

    //Call a method to validate them
    validateAndAdd(firstEvent);
    validateAndAdd(secEvent);
    validateAndAdd(thirdEvent);

    //print the hours left after creating events
    System.out.println(dayPeriod.getHours() + " : " + dayPeriod.getMinutes() + " : " + dayPeriod.getSeconds());

}

public static void validateAndAdd(DateTime[] event) {

    //Subtract the event period from the Day Period
    dayPeriod = dayPeriod.minus(new Period(event[0], event[1]));
    schedule.add(event);
}
}