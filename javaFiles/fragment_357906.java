public Corners getCornersAreSolid(double x, double y) {
    int leftTile = (int)(x / Tile.SIZE);
    int rightTile = (int)((x + moveData.collisionBox.getWidth()) / Tile.SIZE);
    int topTile = (int)(y / Tile.SIZE);
    int bottomTile = (int)((y + moveData.collisionBox.getHeight()) / Tile.SIZE);

    boolean topLeft = hasAttribute(map, Attribute.SOLID, topTile, leftTile);
    boolean topRight = hasAttribute(map, Attribute.SOLID, topTile, rightTile);
    boolean bottomLeft = hasAttribute(map, Attribute.SOLID, bottomTile, leftTile);
    boolean bottomRight = hasAttribute(map, Attribute.SOLID, bottomTile, rightTile);

    Corners solidCorners = new Corners();
    solidCorners.topLeft = topLeft;
    solidCorners.topRight = topRight;
    solidCorners.bottomRight = bottomRight;
    solidCorners.bottomLeft = bottomLeft;
    return solidCorners;
}
private boolean hasAttribute(GameMap map, Attribute attribute, int tileY, int tileX) {
      boolean result = false;

      if (tileX >= 0 && tileX < map.getWidthInTiles() && tileY >= 0 && tileY < map.getHeightInTiles()) {
        result = map.getTileAt(tileX, tileY).getAttribute(attribute);
      }
      return result;
    }
public Vec2D getNextPosition() {

    int currCol = (int) (getX() / Tile.SIZE);
    int currRow = (int) (getY() / Tile.SIZE);

    double destX = getX() + moveData.velocity.x;
    double destY = getY() + moveData.velocity.y;

    double tempX = getX();
    double tempY = getY();

    Corners solidCorners = getCornersAreSolid(getX(), destY);
    boolean topLeft = solidCorners.topLeft;
    boolean topRight = solidCorners.topRight;
    boolean bottomLeft = solidCorners.bottomLeft;
    boolean bottomRight = solidCorners.bottomRight;

    this.framesSinceLastCollision += 1;
    if(moveData.velocity.y < 0) {
        if(topLeft || topRight) {
            moveData.velocity.y = 0;
            tempY = currRow * Tile.SIZE;
            this.framesSinceLastCollision = 0;
        }
        else {
            tempY += moveData.velocity.y;
        }
    }
    else if(moveData.velocity.y > 0) {
        if(bottomLeft || bottomRight) {
            moveData.velocity.y = 0;
            tempY = (currRow + 1) * Tile.SIZE - moveData.collisionBox.getHeight() % Tile.SIZE - 1 ;
            this.framesSinceLastCollision = 0;
        }
        else {
            tempY += moveData.velocity.y;
        }
    }

    solidCorners = getCornersAreSolid(destX, getY());
    topLeft = solidCorners.topLeft;
    topRight = solidCorners.topRight;
    bottomLeft = solidCorners.bottomLeft;
    bottomRight = solidCorners.bottomRight;
    if(moveData.velocity.x < 0) {
        if(topLeft || bottomLeft) {
            moveData.velocity.x = 0;
            tempX = currCol * Tile.SIZE;
            this.framesSinceLastCollision = 0;
        }
        else {
            tempX += moveData.velocity.x;
        }
    }
    if(moveData.velocity.x > 0) {
        if(topRight || bottomRight) {
            moveData.velocity.x = 0;
            tempX = (currCol + 1) * Tile.SIZE - moveData.collisionBox.getWidth() % Tile.SIZE -1 ;
            this.framesSinceLastCollision = 0;
        }
        else {
            tempX += moveData.velocity.x;
        }
    }
    return new Vec2D(tempX, tempY);
}
private static class Corners{
    public boolean topLeft, topRight;
    public boolean bottomLeft, bottomRight;
    public Corners(){
        topLeft = false;
        topRight = false;
        bottomLeft = false;
        bottomRight = false;
    }       
}