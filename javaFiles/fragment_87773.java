rTemp[0] = x0;

for (int i = 0; i < num; i++) 
{
    if(i + 1 != num)
    {
        rTemp[i + 1] = (((rTemp[i] * a) + c) % mod);
    }
    else
    {
        break;
    }
}