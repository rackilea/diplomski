class ImagePanel extends JPanel {
   private final BufferedImage img;

   public ImagePanel() throws IOException {
     setLayout(new GridLayout(6, 6));
     img = ImageIO.read(new File("Battleships.jpg"));
   }

   @Override
   protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
   }
}