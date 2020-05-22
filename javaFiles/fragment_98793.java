public void shake() 
{

    Coin temp;

    for (int i = 0; i < coins.length; i++)
    {
        //int swap = Coin.RANDOM.nextInt(coins.length);
        temp = coins[swap];
        coins[swap] = coins[i];
        coins[i] = temp;

        System.out.print(coins[i] + ", ");
    }
}