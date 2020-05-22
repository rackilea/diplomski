if(mGameAssets[i].getAssetType().isSnake()){ //check if the asset is snake
    // Step 1
    Map<Integer,Integer> assetMap = new HashMap<Integer,Integer>();
    assetMap.put(i, mGameAssets[i].getDamage());
    // Step 2
    mapSnakes.put(++coutner, assetMap);
}