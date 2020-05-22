int objectLayerId = 5;
TiledMapTileLayer collisionObjectLayer = (TiledMapTileLayer)map.getLayers().get(objectLayerId);
MapObjects objects = collisionObjectLayer.getObjects();

// there are several other types, Rectangle is probably the most common one
for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {

    Rectangle rectangle = rectangleObject.getRectangle();
    if (Intersector.overlaps(rectangle, player.getRectangle()) {
        // collision happened
    }
}