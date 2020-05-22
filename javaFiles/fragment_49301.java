protected void paintComponent(Grapchics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, this);
    int cellHeight = (int)(getHeight() / 10);
    int cellWidth = (int)(getWidth() / 10);
    for (int y = 0; y < getWidth(); y += cellHeight) {
        for (int x = 0; x < getHeight(); x += cellWidth){
            g.drawRect(x, y, cellWidth, cellHeight);
        }
    }
}