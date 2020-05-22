public class TestPane extends JPanel {

    private SpriteSheet spriteSheet;
    private SpriteEngine spriteEngine;

    public TestPane() {
        try {
            BufferedImage sheet = ImageIO.read(...);
            spriteSheet = new SpriteSheetBuilder().
                    withSheet(sheet).
                    withColumns(5).
                    withRows(4).
                    withSpriteCount(19).
                    build();

            spriteEngine = new SpriteEngine(25);
            spriteEngine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            spriteEngine.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        BufferedImage sprite = spriteSheet.getSprite(spriteEngine.getCycleProgress());
        int x = (getWidth() - sprite.getWidth()) / 2;
        int y = (getHeight() - sprite.getHeight()) / 2;
        g2d.drawImage(sprite, x, y, this);
        g2d.dispose();
    }

}