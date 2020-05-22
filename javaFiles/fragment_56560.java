class ImagePanel extends JPanel {

    private Image backgroundImg;

    public ImagePanel(Image backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(this),
                             backgroundImage.getHeight(this));
    }
}