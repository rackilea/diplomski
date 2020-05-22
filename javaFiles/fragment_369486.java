public int combos (int amountIn, int startCoin)
{       

    // blah ... existing code ... blah

    for(int i = startCoin; i < coins.length; i++)
    {
        System.out.println("amountIn now is " + amountIn);
        combosCount += combos(amountIn - coins[i], i);
    }