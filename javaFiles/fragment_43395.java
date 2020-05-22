@Override
protected void paintComponent(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    super.paintComponent(g2D);

    int X = 0, Y = 0;
    if (image != null) {

        if (customSize) {
            X = (panelSize.width - imgW) / 2;
            Y = (panelSize.height - imgH) / 2;
        }

        g2D.drawImage(image, X, Y, this);
    }


    if (highlight) {
        g2D.setColor(blueFilter);
        g2D.fillRect(X, Y, image.getWidth(), image.getHeight());
    }

}