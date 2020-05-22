public class CircleControl {

    public static void main(String[] args) {
        new CircleControl();
    }

    public CircleControl() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            add(new Bubble());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            Color startColor = brighten(Color.CYAN, 0.75f);
            Color endColor = brighten(Color.CYAN, 0.5f);

            LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point(0, 0),
                            new Point(0, getHeight()),
                            new float[]{0f, 1f},
                            new Color[]{startColor, endColor});

            g2d.setPaint(lgp);
            g2d.fill(new Rectangle(getWidth(), getHeight()));
            g2d.dispose();

        }
    }

    public class Bubble extends JPanel {

        public Bubble() {
            Font font = UIManager.getFont("Label.font");
            setFont(font.deriveFont(Font.BOLD, 48));
            setForeground(Color.WHITE);
            setBackground(darken(Color.CYAN, 0.3f));
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int x = (getWidth() - 150) / 2;
            int y = (getHeight() - 150) / 2;

            Color startColor = brighten(getBackground(), 0.05f);
            Color endColor = getBackground();

            LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point(x, y),
                            new Point(x, y + 150),
                            new float[]{0f, 1f},
                            new Color[]{startColor, endColor});
            g2d.setPaint(lgp);
            g2d.fill(new Ellipse2D.Double(x, y, 150, 150));

            FontMetrics fm = g2d.getFontMetrics();
            x = x + ((150 - fm.stringWidth("22")) / 2);
            y = y + ((150 / 2) + fm.getAscent());
            g2d.setColor(getForeground());
            g2d.drawString("22", x, y);

        }
    }

    public static Color brighten(Color color, double fraction) {
        int red = (int) Math.round(Math.min(255, color.getRed() + 255 * fraction));
        int green = (int) Math.round(Math.min(255, color.getGreen() + 255 * fraction));
        int blue = (int) Math.round(Math.min(255, color.getBlue() + 255 * fraction));
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }

    public static Color darken(Color color, double fraction) {
        int red = (int) Math.round(Math.max(0, color.getRed() - 255 * fraction));
        int green = (int) Math.round(Math.max(0, color.getGreen() - 255 * fraction));
        int blue = (int) Math.round(Math.max(0, color.getBlue() - 255 * fraction));
        int alpha = color.getAlpha();
        return new Color(red, green, blue, alpha);
    }
}