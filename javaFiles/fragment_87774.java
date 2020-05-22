rTemp[0] = (((x0 * a) + c) % mod);

for (int i = 0; i < num-1; i++) 
{
    rTemp[i + 1] = (((rTemp[i] * a) + c) % mod);
}