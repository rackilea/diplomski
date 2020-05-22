public class Draw {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
        JPanel myPanel = new MyPanel();
        frame.getContentPane().add(myPanel, BorderLayout.CENTER);
        myPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                String xstring = String.valueOf(x);
                String ystring = String.valueOf(y);
                frame.setTitle(xstring + ", " + ystring);
                ((MyPanel) myPanel).setLastPoint(e);
            }

            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                String xstring = String.valueOf(x);
                String ystring = String.valueOf(y);
                frame.setTitle("dragged - " + xstring + ", " + ystring);

                Graphics g = myPanel.getGraphics();
                Point lastPoint = ((MyPanel) myPanel).getLastPoint();
                g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                ((MyPanel) myPanel).setLastPoint(new Point(e.getX(), e.getY()));
                g.dispose();
            }
        });
    }
}

class MyPanel extends JPanel {
    private Point lastPoint;

    public Point getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(Point point) {
        lastPoint = point;

    }

    public void setLastPoint(MouseEvent e) {
        lastPoint = new Point(e.getX(), e.getY());
    }
}