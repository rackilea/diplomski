public class Main extends JFrame {

    static BufferedImage image;

    public static void main(String[] args) {

        try {
            image = ImageIO.read(ClassLoader.getSystemResource("img.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Main();
    }

    public Main() {

        getContentPane().setLayout(new BorderLayout(5, 10));
        BufferedImage img2 = transform(15, 100, 300);

        JLabel label1 = new JLabel(new ImageIcon(image));
        label1.setHorizontalAlignment(JLabel.LEFT);
        label1.setOpaque(true);
        label1.setBackground(Color.YELLOW);
        add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel(new ImageIcon(img2));
        label2.setHorizontalAlignment(JLabel.LEFT);
        label2.setOpaque(true);
        label2.setBackground(Color.CYAN);
        add(label2);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    static BufferedImage transform(int t, int x1, int x2) {

        final double TH = Math.toRadians(t);
        final int D = x2 - x1;
        final int W = image.getWidth();
        final int H = image.getHeight();

        final int dD = (int) (D / (2 * TH) * Math.sin(2 * TH));
        final int dH = (int) (D / TH * Math.pow(Math.sin(TH), 2));
        final int pH = (int) ((W - x2) * Math.tan(2 * TH));

        final int width = W - (D - dD);
        final int height = (int) (H + dH + pH);

        System.out.println(W + " " + H + " -> " + width + " " + height);

        BufferedImage img2 = new BufferedImage(width, height, image.getType());

        for (int x = 0; x < x1; x++) {
            for (int y = 0; y < H; y++) {
                int rgb = image.getRGB(x, y);
                img2.setRGB(x, y, rgb);
            }
        }

        for (int x = x1; x < x2; x++) {
            for (int y = 0; y < H; y++) {
                int rgb = image.getRGB(x, y);
                int dx = (int) (D / (2 * TH) * Math.sin(2 * (x-x1) * TH / D));
                int dy = (int) (D / TH * Math.pow(Math.sin((x-x1) * TH / D), 2));
                img2.setRGB(x1 + dx, y + dy, rgb);
            }
        }

        for (int x = x2; x < W; x++) {
            for (int y = 0; y < H; y++) {
                int rgb = image.getRGB(x, y);
                int dp = (int) ((x - x2) * Math.tan(2 * TH));
                img2.setRGB(x - (D - dD), y + dH + dp, rgb);
            }
        }

        return img2;
    }
}