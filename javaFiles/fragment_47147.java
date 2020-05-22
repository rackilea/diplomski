public class DrawLine extends JPanel {

    private static final int LINE_WIDTH = 8;

    private MouseHandler mouseHandler = new MouseHandler();
    private Point p1 = null;
    private Point p2 = null;
    private boolean drawing;

    private Point draggingPoint = null;

    // Store lines in an arraylist
    private ArrayList<Line> lines = new ArrayList<>();

    public DrawLine() {
        setBackground(Color.white);
        this.setPreferredSize(new Dimension(400, 200));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Grid start
        g.setColor(Color.lightGray);
        int sideLength = 20;
        int nRowCount = getHeight() / sideLength;
        int currentX = sideLength;
        for (int i = 0; i < nRowCount; i++) {
            g.drawLine(0, currentX, getWidth(), currentX);
            currentX = currentX + sideLength;
        }

        int nColumnCount = getWidth() / sideLength;
        int currentY = sideLength;
        for (int i = 0; i < nColumnCount; i++) {
            g.drawLine(currentY, 0, currentY, getHeight());
            currentY = currentY + sideLength;
        }
        // Grid end

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(LINE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));

        if (p1 != null && p2 != null) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // draw all previous lines
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (line.isSelected) {
                g2d.setColor(Color.red);
            } else {
                g2d.setColor(Color.blue);
            }
            g.drawLine(lines.get(i).p1.x, lines.get(i).p1.y, lines.get(i).p2.x, lines.get(i).p2.y);
        }
    }

    private void deSelectAll() {
        for (Line line : lines) {
            line.isSelected = false;
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (!e.isControlDown()) {
                drawing = true;
                p1 = e.getPoint();
                p2 = p1;
                repaint();
            } else {
                for (Line line : lines) {
                    line.isSelected = false;
                    if (isInside(line, e.getPoint())) {
                        line.isSelected = true;
                    }
                }

                draggingPoint = e.getPoint();

                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (!e.isControlDown()) {
                drawing = false;
                p2 = e.getPoint();
                repaint();
                deSelectAll();
                lines.add(new Line(p1, p2));

                p1 = null;
                p2 = null;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (!e.isControlDown()) {
                if (drawing) {
                    p2 = e.getPoint();
                    repaint();
                }
            } else if (draggingPoint != null) {

                int XDiff = e.getPoint().x - draggingPoint.x;
                int YDiff = e.getPoint().y - draggingPoint.y;

                draggingPoint = e.getPoint();

                for (Line line : lines) {
                    if (line.isSelected) {
                        line.p1.x = line.p1.x + XDiff;
                        line.p1.y = line.p1.y + YDiff;
                        line.p2.x = line.p2.x + XDiff;
                        line.p2.y = line.p2.y + YDiff;
                    }
                }

                repaint();
            }
        }

        /**
         * Returns true if the given point is inside the given line.
         */
        private boolean isInside(Line line, Point p) {
            return new Line2D.Double(line.p1, line.p2).ptSegDist(p) < (LINE_WIDTH / 2);
        }
    }

    private void display() {
        JFrame f = new JFrame("LinePanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);

        f.add(new JButton(new DeleteLineAction()), BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private class DeleteLineAction extends AbstractAction {

        public DeleteLineAction() {
            super("Delete");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Iterator<Line> iterator = lines.iterator();

            while (iterator.hasNext()) {
                Line line = iterator.next();

                if (line.isSelected) {
                    iterator.remove();
                }
            }

            repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DrawLine().display();
            }
        });
    }

    class Line {
        Point p1;
        Point p2;

        boolean isSelected;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;

            isSelected = true;
        }
    }
}