//Paint-method
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Square s : squares) {
        s.paint(g2d);
    }
    g2d.dispose(); 
}