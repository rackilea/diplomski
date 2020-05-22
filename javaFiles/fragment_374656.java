public Map(int Width, int Height) {
        width = Width;
        height = Height;
        tiles = new Tile[width][height];
        for (int i = 0; i < width; i++) {
             for (int j = 0; j < width; j++) {
                  tiles[i][j] = new Tile();
             }
        }
    }