public static Double stringToDouble (String x)
{
    if (x !=null)
        return Double.parseDouble(x);

    return null;
}

public static String doubleToString (Double y)
{
    if (y != null)
        return String.valueOf(y);

    return null;
}