int index = 0;
for (Entry<Shape,Color> entry : map.entrySet()) {
    Shape shape = entry.getKey();
    Color color = entry.getValue();

    g2.setColor(color);
    if (!opNumList.isEmpty()) {
        if (opNumList.get(index) == 0)
            g2.draw(shape);
        if (opNumList.get(index) == 1)
            g2.fill(shape);
    }
    index++;
}