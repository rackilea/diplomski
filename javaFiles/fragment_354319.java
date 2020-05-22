public static boolean digitRange(int x, int limit)
{
    int t = Math.abs(x);
    while (t > 0)
    {
        if (t % 10 > limit)
            return false;
        t /= 10;
    }
    return true;
}