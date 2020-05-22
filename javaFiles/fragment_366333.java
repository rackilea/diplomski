if(input.isKeyPressed(Input.KEY_LEFT)){
    System.out.println( "Try to walk left.Tile id left to the player is:"+
                                               map.getTileId(x-1, y, objLayer) );
    if(map.getTileId(x-1, y, objLayer) == 0){
        x--;
    }
}