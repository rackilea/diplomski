int nCoins = 0;
for(int coin=startCoin; coin<coins.length; coin++)
{
    nCoins += count(n-coins[coin], coin);
}
return nCoins;