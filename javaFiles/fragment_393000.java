private static class RectDraw extends JPanel {
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);  
    g.drawRect(230,80,10,10);  
    g.setColor(Color.RED);  
    g.fillRect(230,80,10,10);  
  }

  public Dimension getPreferredSize() {
    return new Dimension(PREF_W, PREF_H); // appropriate constants
  }
}