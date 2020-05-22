private void filterSnakes () {

    // maps asset index => snake
    Map<Integer,Asset> snakes = new HashMap<Integer,Asset>(); 

    // find all the snakes:
    for (int i = 0; i < mGameAssets.length; ++ i) {
        if (mGameAssets[i].getAssetType().isSnake())
            snakes.put(i, mGameAssets[i]);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // now we can process their indices and damage, for example:
    for (Map.Entry<Integer,Asset> snakeEntry : snakes.entrySet()) {
        int index = snakeEntry.getKey();
        int damage = snakeEntry.getValue().getDamage();
        System.out.println("Snake at " + index + " damage is " + damage);
    }

    // and we can find the number of snakes too:
    int snakeCount = snakes.size();
    System.out.println("There are " + snakeCount + " snakes.");

    // bonus: we can even just get a generic collection of the snakes:
    Collection<Asset> snakesOnly = snakes.values();

}