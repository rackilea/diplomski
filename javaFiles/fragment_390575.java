public static boolean areAllEqual(int... values)
{
    if (values.length == 0)
    {
        return true; // Alternative below
    }
    int checkValue = values[0];
    for (int i = 1; i < values.length; i++)
    {
        if (values[i] != checkValue)
        {
            return false;
        }
    }
    return true;
}