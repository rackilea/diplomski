public BufferedImage createImage(JPanel panel) {
    //Get top-left coordinate of drawPanel w.r.t screen
    Point p = new Point(0, 0);
    SwingUtilities.convertPointToScreen(p, panel);

    //Get the region with wiht and heighht of panel and 
    // starting coordinates of p.x and p.y
    Rectangle region = panel.getBounds();
    region.x = p.x;
    region.y = p.y;

    //Get screen capture over the area of region
    BufferedImage bi = null;
    try {
        bi = new Robot().createScreenCapture( region );
    } catch (AWTException ex) {
        Logger.getLogger(MyPaintBrush.class.getName()).log(Level.SEVERE, null, ex);
    }

    return bi;
}