int startAmount = ... ;//in cents
int remainder = startAmount;
int coinCounter = new int[coins.length];
for ( int i = 0; i < coins.length; i++ ){
  int currentCoin = coins[i];//in cents
  coinCointer[i] = 0;
  while( remainder >= currentCoin ){
    coinCointer[i] = coinCointer[i] + 1;
    remainder = remainder - currentCoin;
  }
}
//print out by looping over coinCounter, 
//and use the info contained in the Money class