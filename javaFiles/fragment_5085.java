public int getTile(int layer, int x, int y){
    if(layers!=null && layers.length > layer && layers[layer].length > y && layers[layer][y].length > x)
    {
        return layers[layer][y][x];
    }
    return -1;
}