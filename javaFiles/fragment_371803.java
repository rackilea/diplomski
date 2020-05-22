protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g.create(); // create a copy to rotate
  if (image != null) {
     if (af != null) {
        g2.transform(af);
     }
     g2.drawImage(image, 0, 0, null);
  }
  g2.dispose(); // OK to do this as we created this object
}