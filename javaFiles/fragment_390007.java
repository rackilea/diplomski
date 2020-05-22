private static ShapeRenderer debugShapeRenderer = new ShapeRenderer();

public static void showDebugBoundingBoxes(List<Rectangle> boundingBoxes) {
    debugShapeRenderer.begin(ShapeType.Line); // make sure to end the spritebatch before you call this line
    debugShapeRenderer.setColor(Color.BLUE);
    for (Rectangle rect : boundingBoxes) {
        debugShapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
    }
    debugShapeRenderer.end();
}