@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (i != null && paint == null){
        generateScaledInstance();
    }
    if (paint != null) {
        g.drawImage(paint, 0, 0, this);
    }
}