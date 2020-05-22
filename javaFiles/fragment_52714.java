private static int[] pickCoins(int[] purse, int numPicks)
{
    //A little error check
    if (numPicks > purse.length)
    {
        System.err.println("Can't pick " + numPicks + 
                           " coins from a purse with only " + purse.length + " coins!");
    }

    int[] samples = new int[numPicks];

    // Your sampling code here

    return samples;
}