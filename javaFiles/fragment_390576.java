public static boolean areAllEqual(int checkValue, int... otherValues)
{
    for (int value : otherValues)
    {
        if (value != checkValue)
        {
            return false;
        }
    }
    return true;
}