for(int i = 0; i < coins.length; i++) 
{
    CoinName denomination = coins[i].getDenomination();
    sum = sum + denomination.getCoinValue();
    System.out.println(sum);
}