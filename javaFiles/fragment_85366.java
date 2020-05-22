public void printNStars (int n)
{
    n = IBIO.inputInt ("Enter a number for 'n': ");
    for (int i = 0; i <= n; i++)
        System.out.print ("*");
    System.out.println ("");
}