private static final Calendar calendar = Calendar.getInstance();
private static final Object calendarLock = new Object();

public static int getYear()
{
    synchronized(calendarLock)
    {
        return calendar.get(Calendar.YEAR);
    }
}

// Ditto for other methods