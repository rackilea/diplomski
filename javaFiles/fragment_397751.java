public static ArrayList<Tile> checkMapStatus(JLabel[][] map){
    ArrayList<Tile> mapList = new ArrayList<Tile>();
    Tile[][] temp = new Tile[map.length][];

    for(int i = 0; i < map.length; i++){
        temp[i] = new Tile[map[i].length];
        for(int j = 0; j < map.length; j++){

        // create the surrounding tiles around the current tile (needs fixing)
        Tile tile = new Tile();
        temp[i][j] = tile;

        tile.payload = map[i][j];
        //Just look up and to the left, populate the existing Tiles as you populate the current one
        if(i > 0 && j < temp[i-1].length){
            tile.up = temp[i-1][j];
            temp[i-1][j].down = tile;
        }
        if(j > 0){
            tile.left = temp[i][j-1];
            temp[i][j-1].right = tile;
        }


        mapList.add(tile);

        }
    }
    return mapList;
}