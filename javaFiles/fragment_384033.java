Iterator<Coin> iterator = coinList.iterator(); // Allows us to traverse list
while (iterator.hasNext()) {        // If we use a for-each here, we can't remove coins.
    Coin coin = iterator.next();    // In the first iteration this will be the 1st element, then second, etc.
    if (coin.collides(player)) {    // Your collision logic can go here
        iterator.remove();          // Removes coin from list when collided with player (we don't want it anymore).
        addScore(1);
        // Do other stuff here when coin collides with player
    }
}