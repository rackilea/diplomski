public boolean objectIsOnField(int x, int y){
    for(int i = 0;i < tiles.length;i++){
        Tile t = tiles[i];
        if(t.getX() == x && t.getY() == y)
            return true;
    }
    return false;
}