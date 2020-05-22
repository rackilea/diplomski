int mod(int a, int b)
{
    int ret = a % b;
    if (ret < 0)
        ret += b;
    return ret;
}