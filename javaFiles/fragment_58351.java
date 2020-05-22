public void paintComponent (Graphics g) {
    super.paintComponent(g);
    //g.setColor(new Color(rColor, gColor, bColor));
    //g.fillOval(xStart, yStart, radius, radius);
    for (Circle circle: xxx){
        g.setColor(new Color(circle.rcol, circle.gcol, circle.bcol));
        g.fillOval(circle.x, circle.y, circle.rad, circle.rad);
    }
}