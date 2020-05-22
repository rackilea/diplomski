class ImgPanel extends JPanel {
    private BufferedImage img;

    public ImgPanel(BufferedImage img) {
        this.img = img;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}