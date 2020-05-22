private static Calendar clearTimes(Calendar c) {
    c.set(Calendar.HOUR_OF_DAY,0);
    c.set(Calendar.MINUTE,0);
    c.set(Calendar.SECOND,0);
    c.set(Calendar.MILLISECOND,0);
    return c;
}

public static String convertSimpleDayFormat(long val) {
    Calendar today=Calendar.getInstance();
    today=clearTimes(today);

    Calendar yesterday=Calendar.getInstance();
    yesterday.add(Calendar.DAY_OF_YEAR,-1);
    yesterday=clearTimes(yesterday);

    Calendar last7days=Calendar.getInstance();
    last7days.add(Calendar.DAY_OF_YEAR,-7);
    last7days=clearTimes(last7days);

    Calendar last30days=Calendar.getInstance();
    last30days.add(Calendar.DAY_OF_YEAR,-30);
    last30days=clearTimes(last30days);


    if(val >today.getTimeInMillis())
    {
            return "today";  
    }
    else if(val>yesterday.getTimeInMillis())
    {
        return "yesterday";
    } 
    else if(val>last7days.getTimeInMillis())
    {
        return "last7days";
    } 
    else if(val>last30days.getTimeInMillis())
    {
        return "last30days";
    }
    else
    {
        return "morethan30days";
    }
}