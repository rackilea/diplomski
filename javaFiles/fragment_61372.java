public void paintComponent(Graphics g){
    ...
    g2d.drawImage(bufferedImage,
                  31, 31,
                  width - 30,
                  height - 30,
                  0, 0,
                  bufferedImage.getWidth(), bufferedImage.getHeight(),
                  null);
    ...
    if (drawLegend) {
        g2d.drawRect(width - 20, 30, 10, height - 60);
        ...
    }