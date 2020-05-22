public class FlipPane extends JPanel {

    private BufferedImage masterImage;
    private BufferedImage renderedImage;

    public FlipPane(BufferedImage image) {
        masterImage = image;
        flipMaster();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(renderedImage.getWidth(), renderedImage.getHeight());
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    protected void flipMaster() {
        renderedImage = new BufferedImage(masterImage.getWidth(), masterImage.getHeight(), masterImage.getTransparency());
        Graphics2D g2d = renderedImage.createGraphics();
        g2d.setTransform(AffineTransform.getScaleInstance(1, -1));
        g2d.drawImage(masterImage, 0, -masterImage.getHeight(), this);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth() - 1;
        int height = getHeight() - 1;

        int x = (width - renderedImage.getWidth()) / 2;
        int y = (height - renderedImage.getHeight()) / 2;

        g2d.drawImage(renderedImage, x, y, this);
    }
}