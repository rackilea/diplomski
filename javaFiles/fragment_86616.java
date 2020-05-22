public static String fmt(double d)
{
    if(d == (long) d)
        return String.format("%d",(long)d);
    else
        return String.format("%s",d);
}