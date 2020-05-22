public static int firstOfMonth(int year)
{
    int raw = year - 2000;
    int leapYears = int(raw/4) - int(raw/100) + int(raw/400);
    return ( NOV1 + 365 * raw + leapYears ) % 7;
}