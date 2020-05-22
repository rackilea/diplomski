public void paint(Graphics g){
    // Painting is a complex series of chained methods, failing to call super.paint
    // to cause significant issues
    super.paint(g);
    // Graphics is guaranteed to be an instance of Graphics2D since I think 1.4
    // You should create a copy, so any changes you make are not carried onto the
    // next component, Graphics is shared between all the components being painted
    // in this paint cycle.
    Graphics2D g2=(Graphics2D)g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.drawImage(bg,0,0,null);
    g2.drawImage(bg,0,480,null);
    g2.drawImage(bg,360,0,null);
    g2.drawImage(bg,360,480,null);
    g2.drawImage(bg,720,0,null);
    g2.drawImage(bg,720,480,null);
    g2.drawImage(chara,imgX,imgY,null);
    // If you create, you should dispose of it...
    g2.dispose();
}