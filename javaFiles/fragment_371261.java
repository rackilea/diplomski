int FIXTHISTOSIZE = 10;
    for (int x = px - (FIXTHISTOSIZE / 2); x <= FIXTHISTOSIZE; x++){
        for (int y = py -(FIXTHISTOSIZE / 2); y <= FIXTHISTOSIZE; y++){
            int aY = py + y;
            int aX = px + x;
            Tile tile = new Tile(aX, aY);
            tiles.put("" + aX + "." + aY, tile);
        }
    }
    this.loadTiles(px, py);