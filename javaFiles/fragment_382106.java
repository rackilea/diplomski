@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    RenderingHints rh = g2d.getRenderingHints();
    rh.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHints(rh);

    //Draw space
    int pixelsAcross = H_GAP;
    int pixelsDown = 0;
    int size = GRID_SIZE;
    for (int i = 0; i < grid.getRows(); i++) {
        for (int j = 0; j < grid.getColumns(); j++) {
            g2d.setColor(grid.getNodeGrid()[i][j].getColour());
            g2d.fillRect(pixelsAcross, pixelsDown, size, size);
            g2d.setColor(new Color(0, 0, 0));
            g2d.drawRect(pixelsAcross, pixelsDown, size, size);
            //Better Ovals maybe needed, try Ellipise2D class

            if (grid.getNodeGrid()[i][j].getHasOval() == true) {
                g2d.setColor(new Color(255, 255, 255));
                g2d.fillOval((pixelsAcross + (size / 2) - 1), (pixelsDown + (size / 2) - 1), size / 4, size / 4);
            }
            pixelsAcross += size;
        }
        pixelsDown += size;
        pixelsAcross = H_GAP;
        //Draws gene string for first object in each row
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString(grid.getNodeGrid()[i][0].getGeneString(), 5, pixelsDown - 5);
    }
}