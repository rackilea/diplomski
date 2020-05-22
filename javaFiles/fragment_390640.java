@SuppressWarnings("serial")
public class TopFrame extends JPanel {
    private static final int FRAME_WIDTH = 320;
    private static final int FRAME_HEIGHT = 240;

    private BufferedImage bgImage;

    public TopFrame() {
        this.initComponent();
    }

    private void initComponent() {
        this.setLayout(null);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.setOpaque(false);

        bgImage = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        try {
            bgImage = ImageIO.read(new File("FRAME.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        // super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, this);
    }
}