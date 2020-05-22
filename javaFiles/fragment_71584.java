public static void main(String[] args) {
    new LinkLayerPane();
}

public LinkLayerPane() {
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

            JLayeredPane layer = new JLayeredPane();
            JPanel red = new JPanel();
            red.setBackground(Color.RED);
            JPanel blue = new JPanel();
            blue.setBackground(Color.BLUE);

            red.setBounds(50, 50, 50, 50);
            blue.setBounds(125, 125, 50, 50);

            layer.add(red);
            layer.add(blue);

            layer.add(new LinkPane(red, blue), new Integer(JLayeredPane.DEFAULT_LAYER + 1));
            layer.setPreferredSize(new Dimension(250, 250));

            MouseAdapter ma = new MouseAdapter() {
                private Point offset;
                private Component dragComponent;

                @Override
                public void mousePressed(MouseEvent e) {
                    JLayeredPane layer = (JLayeredPane) e.getComponent();
                    dragComponent = layer.getComponentAt(e.getPoint());
                    if (dragComponent != null && !dragComponent.equals(layer) && !(dragComponent instanceof LinkPane)) {
                        offset = e.getPoint();
                        offset.x = dragComponent.getX() - offset.x;
                        offset.y = dragComponent.getY() - offset.y;
                    } else {
                        dragComponent = null;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragComponent = null;
                    offset = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragComponent != null) {
                        Point dragTo = e.getPoint();
                        dragTo.x += offset.x;
                        dragTo.y += offset.y;
                        dragComponent.setLocation(dragTo);
                    }
                }
            };

            layer.addMouseListener(ma);
            layer.addMouseMotionListener(ma);

            JFrame frame = new JFrame("Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(layer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
}

public class LinkPane extends JPanel {

    private Point startPoint;
    private Point endPoint;
    private JPanel[] links;

    public LinkPane(JPanel panel1, JPanel panel2) {

        setOpaque(false);

        links = new JPanel[]{panel1, panel2};

        ComponentAdapter ca = new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                updateLinks();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                updateLinks();
            }
        };

        links[0].addComponentListener(ca);
        links[1].addComponentListener(ca);

        updateLinks();

    }

    protected void updateLinks() {

        Point p1 = links[0].getLocation();
        Point p2 = links[1].getLocation();

        startPoint = new Point();
        endPoint = new Point();

        Point from = new Point();
        Point to = new Point();

        if (p1.x < p2.x) {
            from.x = p1.x + (links[0].getWidth() / 2);
            to.x = p2.x + (links[1].getWidth() / 2);
        } else {
            from.x = p2.x + (links[1].getWidth() / 2);
            to.x = p1.x + (links[0].getWidth() / 2);
            startPoint.x = p2.x;
        }
        if (p1.y < p2.y) {
            from.y = p1.y + (links[0].getHeight() / 2);
            to.y = p2.y + (links[1].getHeight() / 2);

        } else {
            from.y = p2.y + (links[1].getHeight() / 2);
            to.y = p1.y + (links[0].getHeight() / 2);
        }

        int width = Math.max(1, to.x - from.x);
        int height = Math.max(1, to.y - from.y);

        setLocation(from);
        setSize(width, height);

        System.out.println(getBounds());

        if (p1.x < p2.x) {
            startPoint.x = 0;
            endPoint.x = getWidth();
        } else {
            startPoint.x = getWidth();
            endPoint.x = 0;
        }
        if (p1.y < p2.y) {
            startPoint.y = 0;
            endPoint.y = getHeight();
        } else {
            startPoint.y = getHeight();
            endPoint.y = 0;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        g2d.dispose();
    }
}