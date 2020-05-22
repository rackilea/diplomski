class StopLightPanel extends JPanel {

  private int diameter;
  private Color onColor;
  private Color offColor;
  private boolean lightOn;

  public boolean isLightOn() {
     return lightOn;
  }

  public void setLightOn(boolean lightOn) {
     this.lightOn = lightOn;
     repaint();
  }

  public StopLightPanel(int d, Color c) {

     diameter = d;
     onColor = c.brighter();
     offColor = c.darker().darker();
     lightOn = false;
  }

  public void paintComponent(Graphics g) {

     super.paintComponent(g);
     Color color = lightOn ? onColor : offColor;
     g.setColor(color);
     g.fillOval(10, 10, diameter, diameter);
  }
}