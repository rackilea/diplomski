private void drawTile(Graphics g,MapController mc,int gid){
    int cols = mc.getMap().getTileset().getColumns();

    int x = (gid % cols)-1; 
    if(x<0){x=0};
    int y = gid / cols;
    int tilewidth = mc.getTilewidth();
    int tileheight = mc.getTileheight();
    int dx1 = 0;
    int dx2 = dx1+tilewidth;
    int dy1 = 0;
    int dy2 = dy1+tileheight;
    int sx1 = x*tilewidth;
    int sx2 = sx1+tilewidth;
    int sy1 = y*tileheight;
    int sy2 = sy1+tileheight;
    g.drawImage(mc.getSpriteImage(), dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,      null);

}