import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

public class TemporalCollection {

private Map<DateTime, Object> contents = new HashMap<DateTime, Object>();

private List<DateTime> _milestoneCache;

public Object get(DateTime when) {
    /** returns the value that was effective on the given date */
    Iterator<DateTime> it = milestones().iterator();
    while (it.hasNext()) {
        DateTime thisDate = it.next();
        if (thisDate.isBefore(when) || thisDate.equals(when))
            return contents.get(thisDate);
    }
    throw new IllegalArgumentException("no records that early");
}

public HashMap<Interval, Object> getAdjacentIntervals(Interval when) {
    // start to get the start date object
    DateTime startDate = when.getStart();
    DateTime endDate = when.getEnd();
    HashMap<Interval, Object> result = new HashMap<Interval, Object>();
    Iterator<DateTime> it = milestones().iterator();

    DateTime endDateToCompare = endDate;
    DateTime startDateToCompare = startDate;
    while (it.hasNext()) {
        DateTime thisDate = it.next();
        if (thisDate.isBefore(endDateToCompare)
                || thisDate.equals(endDateToCompare)) {
            Interval adjacentIntervalPart;
            if (thisDate.isAfter(startDateToCompare) &&  !thisDate.equals(endDateToCompare)) {
                // we have hit upper end of the range
                // upper end of the adjacent interval is as follows
                adjacentIntervalPart = new Interval(thisDate,
                        endDateToCompare);

                result.put(adjacentIntervalPart, contents.get(thisDate));

                endDateToCompare = endDateToCompare.minus(new Duration(
                        thisDate, endDateToCompare));

            } else {


                // we have reached the last range
               adjacentIntervalPart = new Interval(startDate, endDateToCompare);
               result.put(adjacentIntervalPart, contents.get(thisDate));

               return result;
            }
        }

    }
    throw new IllegalArgumentException("no records that early for an Interval");

}

public void put(DateTime at, Object item) {
    /** the item is valid and effective from the supplied date onwards */
    contents.put(at, item);
    clearMilestoneCache();
}

private List<DateTime> milestones() {
    /**
     * a list of all the dates where the value changed, returned in order
     * latest first
     */
    if (_milestoneCache == null)
        calculateMilestones();
    return _milestoneCache;
}

private void calculateMilestones() {
    _milestoneCache = new ArrayList<DateTime>(contents.size());
    _milestoneCache.addAll(contents.keySet());
    Collections.sort(_milestoneCache, Collections.reverseOrder());
}

private void clearMilestoneCache() {
    _milestoneCache = null;
}

}