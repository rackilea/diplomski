public int getTile(int layer, int x, int y) {
    try{

    return layers[layer][y][x];
    }
    catch(NullPointerException npe)
    {
        return -1;
    }
}