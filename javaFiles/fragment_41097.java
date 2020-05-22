mText = (TextView) findViewById(R.id.money);
int costOfTransactionInCoins = 30; // new variable
coinCount = 0;
...
if (coinCount < costOfTransactionInCoins) {
   ... }
else {
    coinCount = coinCount - costOfTransactionInCoins;
...
}
...