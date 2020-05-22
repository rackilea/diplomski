class DrawPanel extends JPanel {
    private BufferedImage image;

    public DrawPanel() {
        URL resource = getClass().getResource("cat2.jpg");
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 3, 4, this);
    }
}