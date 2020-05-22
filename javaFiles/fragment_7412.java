public class TestPane extends JPanel {

    private Sprite sprite;

    public TestPane(Sprite sprite) {
        this.sprite = sprite;
        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        BufferedImage img = sprite.getFrame();
        int x = (getWidth() - img.getWidth()) / 2;
        int y = (getHeight() - img.getHeight()) / 2;
        g2d.drawImage(img, x, y, this);
        g2d.dispose();
    }

}