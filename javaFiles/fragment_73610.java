public class DatesAndTimesStackOverflow {

final static SimpleDateFormat sdf;
final static TimeZone tz;
static {
    tz = TimeZone.getTimeZone( "Europe/Paris" );
    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
    sdf.setTimeZone(tz);
}

public static void main(String[] args) {

    // october clock change should be the following:
    outputDateInfo("2012-10-28 02:00:00 CEST");
    outputDateInfo("2012-10-28 02:30:00 CEST");
    outputDateInfo("2012-10-28 02:00:00 CET");
    outputDateInfo("2012-10-28 02:30:00 CET");
    outputDateInfo("2012-10-28 03:00:00 CET");
    outputDateInfo("2012-10-28 03:30:00 CET");
    outputDateInfo("2012-10-28 04:00:00 CET");
}


private static void outputDateInfo(String theDate) {
    try {
        output("------------------------------------------------------------------------------");
        Date d = sdf.parse(theDate);
        Calendar c = GregorianCalendar.getInstance(tz);
        c.setTimeInMillis(d.getTime());
        TimeZone tzCal = c.getTimeZone();

        output("String:                       " + theDate);
        output("");
        output("Date:                         " + d);                   // toString uses current system TimeZone
        output("Date Millis:                  " + d.getTime());
        output("Cal Millis:                   " + c.getTimeInMillis());
        output("Cal To Date Millis:           " + c.getTime().getTime());
        output("Cal TimeZone Name:            " + tzCal.getDisplayName());
        output("Cal TimeZone ID:              " + tzCal.getID());
        output("Cal TimeZone DST Name:        " + tzCal.getDisplayName(true, TimeZone.SHORT));
        output("Cal TimeZone Standard Name:   " + tzCal.getDisplayName(false, TimeZone.SHORT));
        output("In DayLight:                  " + tzCal.inDaylightTime(d));

        output("");
        output("Day Of Month:                 " + c.get(Calendar.DAY_OF_MONTH));
        output("Month Of Year:                " + c.get(Calendar.MONTH));
        output("Year:                         " + c.get(Calendar.YEAR));

        output("Hour Of Day:                  " + c.get(Calendar.HOUR_OF_DAY));
        output("Minute:                       " + c.get(Calendar.MINUTE));
        output("Second:                       " + c.get(Calendar.SECOND));

        // check to see if this converts back to correct string
        String reformat = sdf.format(c.getTime());
        if( reformat.equals(theDate) ) {
            output("ReConvert:                    " + reformat + " OK");
        } else {
            output("ReConvert:                    " + reformat + " <-------- Error.  The converted date is different");
        }

    } catch (ParseException ex) {
        output("Cannot parse this date");
    }
}

private static void output(String message) {
    System.out.println(message);
}
}