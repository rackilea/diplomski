static boolean isDivisibleBy3(int n)
{
    while(n<0 || n>3) {
        n = (n&3) + (n>>2);
    }
    return (n==3 || n==0)
}