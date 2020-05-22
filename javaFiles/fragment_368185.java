int nCoins = 0;
for(int coin=0; coin<coins.length; coin++)
{
    nCoins += count(n-coins[coin]);
}
return nCoins;