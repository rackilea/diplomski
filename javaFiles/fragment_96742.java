if (array[i]%2 == 1)
{
    stretched[2 * i] = array[i]/2 + 1;
    stretched[2 * i + 1] = array[i]/2;
}
else
{
    stretched[2 * i] = array[i]/2;
    stretched[2 * i + 1] = array[i]/2;
}