laserWidth = 8f; //default if no collision is found
for (Tile t : world.getTiles()) {     //pulling in tiles as t, from world method getTiles()
    if (Intersector.overlapRectangles(getLaserBox(), t.getBounds())) {
        laserWidth = laserOrigin.dst(t.getPosition().x, t.getPosition().y + t.getBounds().y);
        break;
    }
}