public class ImagePane extends JPanel {

    private BufferedImage masterImage;
    private BufferedImage renderedImage;

    public ImagePane(BufferedImage image) {
        masterImage = image;
        applyRotation(0);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(renderedImage.getWidth(), renderedImage.getHeight());
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    protected int getVirtualAngle(int angle) {
        float fRotations = (float) angle / 360f;
        int rotations = (int) (fRotations - (fRotations / 1000));

        int virtual = angle - (rotations * 360);

        if (virtual < 0) {
            virtual = 360 + virtual;
        }

        return virtual;
    }

    public void applyRotation(int angle) {
        // This will only work for angles of 90 degrees...

        // Normalize the angle to make sure it's only between 0-360 degrees
        int virtualAngle = getVirtualAngle(angle);
        Dimension size = new Dimension(masterImage.getWidth(), masterImage.getHeight());
        int masterWidth = masterImage.getWidth();
        int masterHeight = masterImage.getHeight();

        double x = 0; //masterWidth / 2.0;
        double y = 0; //masterHeight / 2.0;

        switch (virtualAngle) {
            case 0:
                break;
            case 180:
                break;
            case 90:
            case 270:
                size = new Dimension(masterImage.getHeight(), masterImage.getWidth());
                x = (masterHeight - masterWidth) / 2.0;
                y = (masterWidth - masterHeight) / 2.0;
                break;
        }
        renderedImage = new BufferedImage(size.width, size.height, masterImage.getTransparency());
        Graphics2D g2d = renderedImage.createGraphics();

        AffineTransform at = AffineTransform.getTranslateInstance(x, y);

        at.rotate(Math.toRadians(virtualAngle), masterWidth / 2.0, masterHeight / 2.0);
        g2d.drawImage(masterImage, at, null);

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