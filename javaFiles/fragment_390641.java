@SuppressWarnings("serial")
public class Canvas extends JPanel {
    private static final int CANVAS_WIDTH = 227;
    private static final int CANVAS_HEIGHT = 240;

    BufferedImage image;
    BufferedImage imgBuffer;
    Graphics2D g2d;

    public Canvas() {
        this.initComponent();
    }

    private void initComponent() {
        Timer timer = new Timer();

        this.setBounds(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        imgBuffer = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = imgBuffer.createGraphics();

        try {
            image = ImageIO.read(new File("tile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                drawComponent();
                repaint();
            }
        }, 0, 100);
    }

    public void drawComponent() {
        /* will do tile drawing */
        g2d.drawImage(image, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBuffer, 0, 0, this);
    }
}