void paintComponent(Graphics g) {
    BufferedImage img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
    Graphics2D    gph=(Graphics2D)img.getGraphics();

    // paint to gph here
    gph.dispose();

    g.drawImage(img);  // paints the contents of img to the component's graphics context.
    }