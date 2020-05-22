public Vector2 getNextPointTowardOther(Vector2 dest, int speed) {
    if (dest == null)
        return this;
    double deltaX = dest.getX() - this.x;
    double deltaY = dest.getY() - this.y;

    // Compute the distance 
    double distance = Math.sqrt(deltaX*deltaX+deltaY*deltaY);

    // Compute the (normalized) direction 
    double dirX = deltaX / distance;
    double dirY = deltaY / distance;

    // (The vector (dirX, dirY) now has length 1.0)

    double x = this.x + speed * dirX;
    double y = this.y + speed * dirY;
    return new Vector2(x, y);
}