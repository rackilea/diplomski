public boolean moveX(){
    if(xMove > 0){//Moving right
        int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

        if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
            x += xMove;
        }else{
            x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            State.setState(handler.getGame().menuState);//here!!!
        }

    }else if(xMove < 0){//Moving left
        int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

        if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
            x += xMove;
        }else{
            x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            State.setState(handler.getGame().menuState);//here!!!
        }
    }
    return false;
}

public boolean moveY(){
    if(yMove < 0){//Up
        int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

        if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                !collisionWithTile((int) (x + bounds.x + bounds.width) /     Tile.TILEWIDTH, ty)){
            y += yMove;
        }else{
            y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            State.setState(handler.getGame().menuState);//here!!!
        }