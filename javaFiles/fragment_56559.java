class ImagePanel extends JPanel {

    private Image backgroundImg;

    public ImagePanel(Image backgroundImg) {
        Dimension size = new Dimension(
                             backgroundImg.getWidth(null),
                             backgroundImg.getHeight(null));
        ...
    }

    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, null);
    }
}