public void setPos(double posX, double posY) {
    double distX = posX - this.posX;
    double distY = posY - this.posY;

    // movement distance
    double magnitude = Math.sqrt(distX * distX + distY * distY);

    if (magnitude > 5) {
        // only move, if the distance is greater than 5

        // factor to move to distance 5
        double factor = (magnitude - 5) / magnitude;

        this.posX += distX * factor;
        this.posY += distY * factor;
        rotAngle = Math.toDegrees(Math.atan2(distX, -distY));
    }
}