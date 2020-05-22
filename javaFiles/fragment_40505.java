public static int[] getDigits(int value, int size)
{
    int[] ret = new int[size];
    for (int i = size - 1; i >=0 ; i--)
    {
        ret[i] = value % 10;
        value = value / 10;
    }
    // Perhaps throw an exception here if value is not 0? That would indicate
    // we haven't captured the complete number

    return ret;
}