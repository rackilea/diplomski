//Get the collision, ext, and changing tiles from the object sets on the map
    mCollideTiles = this.getObjectGroupPropertyTiles("COLLIDE",  TMXGroupObjects);  
    mExitTiles = this.getObjectPropertyTiles("EXIT", mTMXObjects);
    mChangingTiles = this.getObjectGroupPropertyTiles("CHANGE", TMXGroupObjects);
...
public ArrayList<TMXTile> getCollideTiles(){
    return mCollideTiles;       
}
...
public ArrayList<TMXTile> getObjectGroupPropertyTiles(String pName, final int pLayer, ArrayList<TMXObjectGroup> pTMXObjectGroups){
    ArrayList<TMXTile> ObjectTile = new ArrayList<TMXTile>();
    for (final TMXObjectGroup pObjectGroups : pTMXObjectGroups) {
        // Iterates through the properties and assigns them to the new variable
        for (final TMXObjectGroupProperty pGroupProperties : pObjectGroups.getTMXObjectGroupProperties()) {
            //Sees if any of the elements have this condition
            if (pGroupProperties.getName().contains(pName)) {
                for (final TMXObject pObjectTiles : pObjectGroups.getTMXObjects()) {
                    int ObjectX = pObjectTiles.getX();
                    int ObjectY = pObjectTiles.getY();
                    // Gets the number of rows and columns in the object
                    int ObjectRows = pObjectTiles.getHeight() / WorldActivity.TILE_HEIGHT;
                    int ObjectColumns = pObjectTiles.getWidth() / WorldActivity.TILE_WIDTH;

                    for (int TileRow = 0; TileRow < ObjectRows; TileRow++) {
                        for (int TileColumn = 0; TileColumn < ObjectColumns; TileColumn++) {
                            float lObjectTileX = ObjectX + TileColumn * WorldActivity.TILE_WIDTH;
                            float lObjectTileY = ObjectY + TileRow * WorldActivity.TILE_HEIGHT;
                            ObjectTile.add(mTMXTiledMap.getTMXLayers().get(pLayer).getTMXTileAt(lObjectTileX, lObjectTileY));                       
                        }                            
                    }
                }
            }           
        }
    }
    return ObjectTile;
}