for (Entry<Shape,Color> entry : map.entrySet()) {
    Shape shape = entry.getKey();
    Color color = entry.getValue();

    g2.setColor(color);
    g2.draw(shape);
}