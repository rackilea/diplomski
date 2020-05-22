@Test
public void dayTest()
{
    for (int y = 2099; y <=2100; y++)
    {
        int day = easterSundayDay(y);
        int month = easterSundayMonth(y);

        assertTrue("Wrong year: " + day + "."+ month + "."+ y + " is day: " + dayOfWeek(day, month, y), 1 ==dayOfWeek(day, month, y));
    }
}

public int easterSundayDay(int year)
{
    int c = year/100;
    int n = year - 19*(int)(year/19);
    int k = (c - 17)/25;
    int i = c - (int)(c/4) - (int)((c - k)/3) + 19*n + 15;
    i -= 30*(int)(i/30);
    i -= (int)(i/28)*(1 - (int)(i/28)*(int)(29/(i + 1))*(int)((21 - n)/11));
    int j = year + (int)(year/4) + i + 2 - c + (int)(c/4);
    j -= 7*(int)(j/7);
    int l = i - j;
    int m = 3 + (int)((l + 40)/44); //Your month when is Easter Sunday
    int d = l + 28 - 31*(int)(m/4);

    return d;
}

public int easterSundayMonth(int year)
{
    int c = year/100;
    int n = year - 19*(int)(year/19);
    int k = (c - 17)/25;
    int i = c - (int)(c/4) - (int)((c - k)/3) + 19*n + 15;
    i -= 30*(int)(i/30);
    i -= (int)(i/28)*(1 - (int)(i/28)*(int)(29/(i + 1))*(int)((21 - n)/11));
    int j = year + (int)(year/4) + i + 2 - c + (int)(c/4);
    j -= 7*(int)(j/7);
    int l = i - j;
    int m = 3 + (int)((l + 40)/44); //Your month when is Easter Sunday
    int d = l + 28 - 31*(int)(m/4);

    return m;
}
public int dayOfWeek(int day, int month, int year)
{
    int [] CENTURY_TABLE = {0, 5, 3, 1};
    int [] MONTH_TABLE = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
    boolean leap = false;
    int t1 = (day + MONTH_TABLE[month - 1]) % 7;
    int m1 = year % 100;
    int t2 = (m1 % 7) + (m1/4) + CENTURY_TABLE[((int)(year/100)) % CENTURY_TABLE.length] - (leap  &&  (month == 1  || month == 2) ? 1 : 0);
    if(t2 == -1){
        t2 = 6;
    }
    int d = (t1 + t2) % 7;

    return d;
}