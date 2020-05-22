@Override
public void paintComponent(Graphics g) {
    //Does all the drawing and contains whatever state information is associated with the photo
    //create an action event to auto call repaint
    //call repaint anytime flip was changed to true or false
    super.paintComponent(g);
    g2 = (Graphics2D) g;
    int x = (contentAreaWidth - pic.getWidth(null)) / 2;
    int y = (contentAreaHeight - pic.getHeight(null)) / 2;
    if (!flipped) {
        g2.drawImage(pic, x, y, null);

    } else if (flipped) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, pic.getWidth(null), pic.getHeight(null));
        g2.drawRect(x, y, pic.getWidth(null), pic.getHeight(null));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.RED);
    }

    //took the code you already used for drawing the oval and moved it here
    if (drawOval) {
        g2.setPaint(Color.RED);
        int brushSize = 5;
        g2.fillOval((ovalX - (brushSize / 2)), (ovalY - (brushSize / 2)), brushSize, brushSize);
    }
}