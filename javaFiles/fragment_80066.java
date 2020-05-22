Graphics2D graphics = image.createGraphics();

Iterator iterator = setOfRectangles.iterator();
while(iterator.hasNext()) {
    Rectangle rect = (Rectangle)iterator.next();
    float thickness = 3.0F;
    Stroke stroke = graphics.getStroke();
    graphics.setStroke(new BasicStroke(thickness));

    graphics.drawRoundRect(rect.x, rect.y, rect.height, rect.width, 5, 5);
    graphics.setStroke(stroke);
    graphics.setColor(Color.RED);
}

wholeImage.setContent(image);
graphics.dispose();