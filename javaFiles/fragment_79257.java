public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2d)g;

    // How to scale the image:
    double xscale = ((double)WIDTH) / image.getWidth();
    double yscale = ((double)HEIGHT) / image.getHeight());

    // When scaling proportionally:
    double scale = Math.min(xscale, yscale); // max for covering entire panel.
    xscale = scale;
    yscale = scale;

    double w = scalex * image.getWidth();
    double h = scaley * image.getHeight();
    double x = (getWidth() - w) / 2;
    double y = (getHeight() - h) / 2;
    g.drawImage(img, (int)x, (int)y, (int)w, (int)h, Color.BLACK, null);
    //g2d.translate(x, y);
    //g2d.scale(xscale, yscale);
    //g2d.draw...;
}