public static float geometricSum(int k,int a)
{

    if(k == 0)

        return 1;

    a = a*2;
    return ((float)1/a) + geometricSum(k-1, a);

}