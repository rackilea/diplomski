public static boolean isSumOf(int [] s,int n)
{
    if(n == 0)
        return true;
    if(n < 0)
        return false;

    return withoutLoop(s, n, 0);  // Change here.
}