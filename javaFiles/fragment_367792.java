static void p(int n)
{

    System.out.println(n);
    if (n > 0)
    {
        p(n-1);
    }
    System.out.println(n);

}