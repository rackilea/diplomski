public static double GetPrice (double temp)
{
    if (temp >= 0 && temp < 50)
    {
        return 0.50;
    } else if (temp >= 50 && temp <= 60) {
        return 0.55;
    }
}