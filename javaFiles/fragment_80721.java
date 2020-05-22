public class MouseDraggedTest {

    public static void main(String[] args) {
        new MouseDraggedTest();
    }

    public MouseDraggedTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Map<Point, List<Point>> mapPoints;
        private Point currentPoint;

        public TestPane() {
            mapPoints = new HashMap<>(25);
            MouseAdapter mouseListener = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentPoint = e.getPoint();
                    mapPoints.put(currentPoint, new ArrayList<Point>(25));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    List<Point> points = mapPoints.get(currentPoint);
                    if (points.isEmpty()) {
                        mapPoints.remove(currentPoint);
                    }
                    currentPoint = null;
                }

                @Override
                public void mouseDragged(MouseEvent me) {
                    List<Point> points = mapPoints.get(currentPoint);
                    points.add(me.getPoint());
                    repaint();
                }
            };
            addMouseListener(mouseListener);
            addMouseMotionListener(mouseListener);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Point startPoint : mapPoints.keySet()) {
                List<Point> points = mapPoints.get(startPoint);
                for (Point p : points) {
                    if (startPoint != null) {
                        g.drawLine(startPoint.x, startPoint.y, p.x, p.y);
                    }
                    startPoint = p;
                }
            }
        }
    }
}