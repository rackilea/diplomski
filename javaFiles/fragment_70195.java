class TargetLogoPanel extends JPanel {
   private static final int PREF_W = 700; //!!
   private static final int PREF_H = 300;
   private boolean isTarget;

   public void paintComponent(Graphics g) {
      super.paintComponent(g); // erase back
      Graphics2D g2 = (Graphics2D) g;
      // rendering your circles smoothly
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      Color c = null;
      if (isTarget) {
         c = Color.BLUE;
      } else {
         c = Color.RED;
      }

      g2.setColor(c);
      g2.fill(new Ellipse2D.Double(250, 50, 160, 160));

      g2.setColor(Color.WHITE);
      g2.fill(new Ellipse2D.Double(275, 75, 110, 110));

      g2.setColor(c);
      g2.fill(new Ellipse2D.Double(300, 100, 60, 60));
   }

   @Override  //!!
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public boolean isTarget() {
      return isTarget;
   }

   public void setTarget(boolean isTarget) {
      this.isTarget = isTarget;
   }

}