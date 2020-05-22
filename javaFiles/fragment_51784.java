@Override
protected void processTextPosition(TextPosition text) {
    Matrix textMatrix = text.getTextMatrix();
    Vector start = textMatrix.transform(new Vector(0, 0));

    PDGraphicsState gs = getGraphicsState();
    Area area = gs.getCurrentClippingPath();
    if (area == null || area.contains(start.getX(), start.getY()))
        super.processTextPosition(text);
}