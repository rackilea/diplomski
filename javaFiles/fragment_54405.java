public class Silo extends JComponent {

    BufferedImage img;

    public Silo() throws IOException {
        img = ImageIO.read(new File("img/EmptySilo.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

}