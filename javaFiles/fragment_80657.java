public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(Point p : points){
        g.fillRect(p.x, p.y, 20, 20);
    }
}