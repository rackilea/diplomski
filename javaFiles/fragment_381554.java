public class SpriteField extends JPanel {

    private Ball mSolo;
    private Timer timer;

    private int xDelta, yDelta;

    public SpriteField() {
        mSolo = new Ball();

        do {
            xDelta = (int) ((Math.random() * 8) - 4);
        } while (xDelta == 0);
        do {
            yDelta = (int) ((Math.random() * 8) - 4);
        } while (yDelta == 0);
    }

    public void start() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mSolo.xPos += xDelta;
                    mSolo.yPos += yDelta;

                    if (mSolo.xPos - (mSolo.diameter / 2) < 0) {
                        mSolo.xPos = mSolo.diameter / 2;
                        xDelta *= -1;
                    } else if (mSolo.xPos + (mSolo.diameter / 2) > getWidth()) {
                        mSolo.xPos = getWidth() - (mSolo.diameter / 2);
                        xDelta *= -1;
                    }
                    if (mSolo.yPos - (mSolo.diameter / 2) < 0) {
                        mSolo.yPos = (mSolo.diameter / 2);
                        yDelta *= -1;
                    } else if (mSolo.yPos + (mSolo.diameter / 2) > getHeight()) {
                        mSolo.yPos = getHeight() - (mSolo.diameter / 2);
                        yDelta *= -1;
                    }
                    repaint();
                }
            });
            timer.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        mSolo.DrawSprite(g2);
    }

}