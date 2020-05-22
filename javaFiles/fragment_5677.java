public void updateTiles() {
    for (int i = 0; i < tilearray.size(); i++) {
        Tile t = (Tile) tilearray.get(i);//<-- tile is null in some cases
        t.update();
    }
}