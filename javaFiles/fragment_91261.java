public class DrawIt {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final int width = 400;
        final int height = 400;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };
        frame.add(component);
        frame.setVisible(true);

    }

    public static void drawpuzzle(Graphics g, int x1, int y1, int length, int count) {
        if (count> 0) {
            int x2 = x1 + length;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);

            x1 = x2;
            y1 = y2;

            y2 = y1 - length;
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
            length += 10;

            x2 = x1 - length;
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
            y2 = y1 + length;
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
            length += 10;
            drawpuzzle(g, x1, y1, length, count - 1);
        }

    }

    public static void draw(Graphics g) {
        int x1 = 100;
        int y1 = 100;
        int length = 10;
        int count = 10;
        drawpuzzle(g, x1, y1, length, count);

    }
}