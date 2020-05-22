public class TestMouseDrag {

    public static void main(String[] args) {
        new TestMouseDrag();
    }

    public TestMouseDrag() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new DragMyIcon());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected class DragMyIcon extends JPanel {

        private JLabel label;

        public DragMyIcon() {

            ImageIcon icon = null;

            try {
                icon = new ImageIcon(ImageIO.read(getClass().getResource("/bomb.png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            label = new JLabel(icon);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);

            setLayout(new BorderLayout());
            add(label);

            MouseHandler handler = new MouseHandler();
            label.addMouseListener(handler);
            label.addMouseMotionListener(handler);

        }

    }

    protected class MouseHandler extends MouseAdapter {

        private boolean active = false;

        @Override
        public void mousePressed(MouseEvent e) {

            JLabel label = (JLabel) e.getComponent();
            Point point = e.getPoint();

            active = getIconCell(label).contains(point);
            if (active) {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            } else {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            active = false;
            JLabel label = (JLabel) e.getComponent();
            label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (active) {
                JLabel label = (JLabel) e.getComponent();
                Point point = e.getPoint();

                int verticalAlign = label.getVerticalAlignment();
                int horizontalAlign = label.getHorizontalAlignment();

                if (isWithInColumn(label, point, 0)) {
                    horizontalAlign = JLabel.LEFT;
                } else if (isWithInColumn(label, point, 1)) {
                    horizontalAlign = JLabel.CENTER;
                } else if (isWithInColumn(label, point, 2)) {
                    horizontalAlign = JLabel.RIGHT;
                }

                if (isWithInRow(label, point, 0)) {
                    verticalAlign = JLabel.TOP;
                } else if (isWithInRow(label, point, 1)) {
                    verticalAlign = JLabel.CENTER;
                } else if (isWithInRow(label, point, 2)) {
                    verticalAlign = JLabel.BOTTOM;
                }

                label.setVerticalAlignment(verticalAlign);
                label.setHorizontalAlignment(horizontalAlign);

                label.invalidate();
                label.repaint();

            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        protected boolean isWithInColumn(JLabel label, Point p, int gridx) {
            int cellWidth = label.getWidth() / 3;
            int cellHeight = label.getHeight();

            Rectangle bounds = new Rectangle(gridx * cellWidth, 0, cellWidth, cellHeight);

            return bounds.contains(p);
        }

        protected boolean isWithInRow(JLabel label, Point p, int gridY) {
            int cellWidth = label.getWidth();
            int cellHeight = label.getHeight() / 3;

            Rectangle bounds = new Rectangle(0, cellHeight * gridY, cellWidth, cellHeight);

            return bounds.contains(p);
        }

        private Rectangle getIconCell(JLabel label) {

            Rectangle bounds = new Rectangle();

            int cellWidth = label.getWidth() / 3;
            int cellHeight = label.getHeight() / 3;

            bounds.width = cellWidth;
            bounds.height = cellHeight;

            if (label.getHorizontalAlignment() == JLabel.LEFT) {
                bounds.x = 0;
            } else if (label.getHorizontalAlignment() == JLabel.CENTER) {
                bounds.x = cellWidth;
            } else if (label.getHorizontalAlignment() == JLabel.RIGHT) {
                bounds.x = cellWidth * 2;
            } else {
                bounds.x = 0;
                bounds.width = 0;
            }
            //if (label.getHorizontalAlignment() == JLabel.TOP) {
            //    bounds.y = 0;
            //} else if (label.getHorizontalAlignment() == JLabel.CENTER) {
            //    bounds.y = cellHeight;
            //} else if (label.getHorizontalAlignment() == JLabel.BOTTOM) {
            //    bounds.y = cellHeight * 2;
            //} else {
            //    bounds.y = 0;
            //    bounds.height = 0;
            //}
            if (label.getVerticalAlignment() == JLabel.TOP) {
                bounds.y = 0;
            } else if (label.getVerticalAlignment() == JLabel.CENTER) {
                bounds.y = cellHeight;
            } else if (label.getVerticalAlignment() == JLabel.BOTTOM) {
                bounds.y = cellHeight * 2;
            } else {
                bounds.y = 0;
                bounds.height = 0;
            }

            return bounds;

        }

    }

}