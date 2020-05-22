public enum Calendar
{
    JANUARY(30),
    FEBRUARY(28),
    // etc etc
    ;

    private final int daysInMonth;

    Calendar(final int daysInMonth)
    {
        this.daysInMonth = daysInMonth;
    }

    public int getDaysInMonth()
    {
        return daysInMonth;
    }
}