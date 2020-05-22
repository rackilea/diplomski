private void drawCoins(float runtTime){
    for (Coin coin : coinList) { // For every coin in the coin list do the following.
        // Because we removed coins when they collided, the only things in the list will be the ones that haven't been collided with yet.
        batcher.draw(coinAnimation.getKeyFrame(runtTime), coin.getX(), coin.getY(), coin.getWidth(), coin.getWidth());
    }
}