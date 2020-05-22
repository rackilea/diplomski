@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;        

    frog = new Frog();// <-- !!!!!

    // Frog graphics
    g2.setColor(Color.BLACK);
    g2.drawPolygon(frog);
    g2.setColor(new Color(0,150,15));
    g2.fillPolygon(frog);
}