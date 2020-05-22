public class Test extends JFrame {

    Test() {
        final int x1 = 100, y1 = 100, x2 = 300, y2 = 300;

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x > x1 && x < x2 && y > y1 && y < y2)
                    setCursor(blankCursor);
                else
                    setCursor(defaultCursor);
            }
        });

        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test());
    }
}