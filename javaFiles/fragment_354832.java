private static int myPow(int a, int b, int mod){
    int ret = 1;
    for(int i = 0; i < b; i++)
    {
        ret = (ret * a) % mod;
    }
    return ret;
}