private class TransparentBG extends JLabel {
  BufferedImage image;

  public TransparentBG() throws IOException {
     image = ImageIO.read(TransparentBG.class.getClassLoader()
           .getResourceAsStream("footballQuestioner/rightAnswerSign.png"));
  }

  @Override
  protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     if (image != null) {
        g2d.drawImage(image, 0, 0, null);
     }
     // g2d.dispose();
  }

  @Override
  public Dimension getPreferredSize() {
     if (image != null) {
        int w = image.getWidth();
        int h = image.getHeight();
        return new Dimension(w, h);
     }
     return super.getPreferredSize();
  }
}