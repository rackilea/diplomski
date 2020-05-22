public static boolean compareToHour(int arg)
{
    Calendar temp = Calendar.getInstance();
    int tempHour = temp.get(Calendar.HOUR_OF_DAY);
    return arg==tempHour;

}