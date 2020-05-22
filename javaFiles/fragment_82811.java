public void draw(Graphics2D graphics, int width, int height) {
    PolygonShape polygonShape = (PolygonShape) body.getFixtureList().getShape();

    Vec2[] vertices = polygonShape.getVertices();
    Vec2[] verticesTransform = new Vec2[polygonShape.getVertexCount()];

    for(int i = 0; i < polygonShape.getVertexCount(); i++) {
        verticesTransform[i] = body.getWorldPoint(vertices[i]);

        System.out.println(verticesTransform[i]);
    }

    DrawShape.drawPolygon(graphics, verticesTransform, verticesTransform.length, Color.WHITE);
}