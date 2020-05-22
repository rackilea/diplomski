class ImagePanel extends JPanel {
   @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0,100,200,300);
   }

   @Override
   public Dimension getPreferredSize() {
        return new Dimension(500,300); //for example
   }
}