package demo;

import java.util.Date;

public class FilterDemo {

public static void main(String[] args) throws Exception {
    Filter f = new Filter(new Date(2017, 01, 01), new Date(2017, 02, 01),
            null, null, null, null);

}

public static final class Filter {
    private final Date startDateFrom;
    private final Date startDateTo;

    private final Date endDateFrom;
    private final Date endDateTo;

    private final Date regDateFrom;
    private final Date regDateTo;
    // dateCounter will maintain the count of correct date pair
    public static int dateCount = 0;

    public Filter(Date startDateFrom, Date startDateTo, Date endDateFrom,
            Date endDateTo, Date regDateFrom, Date regDateTo)
            throws Exception {
        this.startDateFrom = startDateFrom;
        this.startDateTo = startDateTo;
        isExist(startDateFrom, startDateTo);
        this.endDateFrom = endDateFrom;
        this.endDateTo = endDateTo;
        isExist(endDateFrom, endDateTo);
        this.regDateFrom = regDateFrom;
        this.regDateTo = regDateTo;
        isExist(regDateFrom, regDateTo);
        //  throw exception after initializing 3 pair,if count is still 0
        if (dateCount == 0)
            throw new Exception("All pairs are null");
    }

    public static void isExist(Date from, Date to) throws Exception {
        if (from != null && to != null) {
            checkDates(from, to);
        }
    }

    public static void checkDates(Date from, Date to) throws Exception {
        if (from.getTime() > to.getTime()) {
            throw new Exception("INCORRECT_DATES_PERIOD");
        }
        //increase dateCount if date pair is correct
        dateCount++;
    }
}

}