  public void paint(Graphics g) {
      // clear off screen bitmap
      super.paint(g);
      // cast graphics to graphics 2D
      Graphics2D g2 = (Graphics2D) g;
      AffineTransform tfm = new AffineTransform();
      tfm.rotate(0,0,0);
      g2.setTransform(tfm);
      g2.drawImage(backImage, 0, 0, this);
      tfm.rotate(Math.toRadians(player.angle+90), player.x+32, player.y+32);
      g2.setTransform(tfm);
      g2.drawImage(tank, player.x, player.y, this);       
  }