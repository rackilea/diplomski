int FIXTHISTOSIZE = 10;
    for (int x = px - (FIXTHISTOSIZE / 2); x <= FIXTHISTOSIZE; x++){
        for (int y = py - (FIXTHISTOSIZE / 2); y <= FIXTHISTOSIZE; y++){
            int aY = py + y;
            int aX = px + x;

            float TOP_LEFT = 0, TOP_RIGHT = 0, BOTTOM_LEFT = 0, BOTTOM_RIGHT = 0;
            Tile TILE_CENTER = tiles.get("" + aX + "." + aY);
            if (TILE_CENTER.isLoaded()) {
                continue;
            }
            Tile TILE_TOP_RIGHT      = tiles.get("" + (aX + 1) + "." + (aY + 1));
            Tile TILE_TOP            = tiles.get("" +  aX      + "." + (aY + 1));
            Tile TILE_RIGHT          = tiles.get("" + (aX + 1) + "." + aY);
            Tile TILE_BOTTOM_RIGHT   = tiles.get("" + (aX + 1) + "." + (aY - 1));
            Tile TILE_BOTTOM         = tiles.get("" +  aX      + "." + (aY - 1));
            Tile TILE_BOTTOM_LEFT    = tiles.get("" + (aX - 1) + "." + (aY - 1));
            Tile TILE_LEFT           = tiles.get("" + (aX - 1) + "." + aY);
            Tile TILE_TOP_LEFT       = tiles.get("" + (aX - 1) + "." + (aY + 1));
            //TOP_RIGHT
            if (TILE_TOP != null && TILE_TOP_RIGHT != null && TILE_RIGHT != null){
                float[] dub = {TILE_TOP.getCenter(), TILE_TOP_RIGHT.getCenter(),TILE_RIGHT.getCenter(),TILE_CENTER.getCenter()};
                TOP_RIGHT = getMedian(dub);
            }
            //TOP_LEFT
            if (TILE_TOP != null && TILE_TOP_LEFT != null && TILE_LEFT != null){
                float[] dub = {TILE_TOP.getCenter(), TILE_TOP_LEFT.getCenter(),TILE_LEFT.getCenter(),TILE_CENTER.getCenter()};
                TOP_LEFT = getMedian(dub);
            }   
            //BOTTOM_LEFT
            if (TILE_BOTTOM != null && TILE_BOTTOM_LEFT != null && TILE_LEFT != null){
                float[] dub = {TILE_BOTTOM.getCenter(), TILE_BOTTOM_LEFT.getCenter(),TILE_LEFT.getCenter(),TILE_CENTER.getCenter()};
                BOTTOM_LEFT = getMedian(dub);
            }   
            //BOTTOM_RIGHT
            if (TILE_BOTTOM != null && TILE_BOTTOM_RIGHT != null && TILE_RIGHT != null){
                float[] dub = {TILE_BOTTOM.getCenter(), TILE_BOTTOM_RIGHT.getCenter(),TILE_RIGHT.getCenter(),TILE_CENTER.getCenter()};
                BOTTOM_RIGHT = getMedian(dub);
            }   

            TILE_CENTER.setConditions(TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT);