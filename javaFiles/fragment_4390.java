void printLoToHi(int n)
{
    if (n < 1)
        return;
    printLoToHi(n-1);
    printMany(n);
}

void printHiToLo(int n)
{
    if (n < 1)
        return;
    printMany(n);
    printHiToLo(n-1);
}