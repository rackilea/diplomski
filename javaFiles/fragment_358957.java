public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for(ShapeWrapper s: shapesDraw){
        g2d.setColor(s.color);
        g2d.draw(s.shape);
    }
    for(ShapeWrappers s : shapesFill){
        g2d.setColor(s.color);
        g2d.fill(s.shape);
    }
}