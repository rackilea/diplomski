public class DefineArea {

    public static void main(String[] args) throws IOException {

        displayImage();
    }
    private static void displayImage() throws IOException {

        //  URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
        //    BufferedImage image = ImageIO.read(url);
        //    ImageIcon icon= new ImageIcon(image);

        URL url = DefineArea.class.getResource("image.jpg");
        BufferedImage image = ImageIO.read(url);
        ImageIcon icon = new ImageIcon(image);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);

        JScrollPane jsp = new JScrollPane(lbl);
        frame.add(jsp);

        //add glass pane to layered pane
        JComponent glass = new paintRectangles();
        JLayeredPane lp = frame.getLayeredPane();
        int w = icon.getIconWidth(); int h = icon.getIconHeight();
        // Size is needed here, as there is no layout in lp
        //to make it useful you need to dynamically adjust glass size
        glass.setSize(w,h);
        lp.add(glass);

        frame.pack();
        frame.setVisible(true);
    }

    public static class paintRectangles extends JComponent {
        ArrayList<Shape> shapes = new ArrayList<>();
        Point startDrag, endDrag;

        public paintRectangles() throws IOException {

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("mousePressed");
                    startDrag = new Point(e.getX(), e.getY());
                    endDrag = startDrag;
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Shape r = makeRectangle(startDrag.x, startDrag.y, e.getX(), e.getY());
                    shapes.add(r);
                    startDrag = null;
                    endDrag = null;
                    repaint();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    endDrag = new Point(e.getX(), e.getY());
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color[] colors = { Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.RED, Color.BLUE, Color.PINK };
            int colorIndex = 0;

            g2.setStroke(new BasicStroke(2));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

            for (Shape s : shapes) {
                g2.setPaint(Color.BLACK);
                g2.draw(s);
                g2.setPaint(colors[(colorIndex++) % 6]);
                g2.fill(s);
            }

            if ((startDrag != null) && (endDrag != null)) {
                g2.setPaint(Color.LIGHT_GRAY);
                Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
                g2.draw(r);
                System.out.println(r.getBounds2D());
            }
        }
    }

    private static Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
                                            Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}