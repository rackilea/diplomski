/*
 * Computes and returns the next year in which New Year's Day will
 * fall on the same day of the week as in a given year.
 */
public int newYears(int year)
{
    // First, find out what day of the week it falls on in year X
    Calendar calendar = new GregorianCalendar(); // create a calendar object
    calendar.set(year, 0, 1); // calendar.set([year], January, 1st)
    int day = calendar.get(Calendar.DAY_OF_WEEK); // store this value for later

    // The code between the curly braces below will be executed 30 times,
    // the first time i = 1, the second i = 2, third i = 3, etc...
    for(int i = 1; true; i++)
    {
        calendar.set(year + i, 0, 1); // set the calendar to the next year
        if(calendar.get(Calendar.DAY_OF_WEEK) == day) // compare to the value we stored earlier, and if it's the same day...
        {
            return year + i; // we have the correct year!
        }
    }
}