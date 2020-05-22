public Shape getTransformedInstance() {
    AffineTransform at = new AffineTransform();
    Rectangle bounds = getBounds();
    at.rotate(Math.toRadians(angle), x + (bounds.width / 2), y + (bounds.height / 2));
    at.translate(x, y);
    return createTransformedShape(at);
}