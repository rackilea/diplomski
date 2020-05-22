public void collect() {
    // Holds the Coins we want to remove from toRender
    final Collection<GameObject> toRemove = new LinkedList<>();

    for (GameObject o : toRender) {
        if (Player.getInstance(null).hasCollected(o)) {
            if (o.equals(toRender.get(3))) {
                final Coin coin = (Coin) toRender.get(3);
                coin.dispose();
                toRemove.add(coin);
            }
            if (o.equals(toRender.get(4))) {
                final Coin coin = (Coin) toRender.get(4);
                coin.dispose();
                toRemove.add(coin);
            }
        }
    }

    // Remove the collected Coins
    toRender.removeAll(toRemove);
}