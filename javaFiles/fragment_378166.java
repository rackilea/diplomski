private static long getTimeInMinutesFromEpoch(Date d) {
    if (d == null) {
        return 0;
    }
    return d.getTime() / (60 * 1000);
}

public static long getMinuteDifference(Date a, Date b) {
    return Math.abs(getTimeInMinutesFromEpoch(b)
            - getTimeInMinutesFromEpoch(a));
}

public static void main(String[] args) throws ParseException {
    String startstring = "Mar 07, 2014 23:45:43 PM";
    String endstring = "Mar 07, 2014 23:46:01 PM";
    DateFormat df = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a",
            Locale.ENGLISH);

    Date start = df.parse(endstring);
    Date end = df.parse(startstring);
    System.out.println(getMinuteDifference(start, end));
}