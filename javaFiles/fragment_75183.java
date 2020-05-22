public class GridPanel extends JPanel implements MouseMotionListener, MouseListener {

    private Rectangle offdutyRect, sbRect, driveRect, onRect;
    private int delta = 60;
    private int[][] gridArray;
    int draggedStartX = -1;
    int draggedStartY = -1;
    private int dutyStatusSpacing = 60;
    private int totalSpacing = 100;

    public GridPanel() {
        setBackground(Color.WHITE);
        //this.setSize(new Dimension(800, 100));
        this.addMouseMotionListener((MouseMotionListener) this);
        this.addMouseListener(this);
        int gridArrayColumns = 24 * 60 / delta;
        gridArray = new int[4][gridArrayColumns];

        int r = 0;
        int rHeight = this.getHeight() / 4;
        offdutyRect = new Rectangle(dutyStatusSpacing, r * rHeight, this.getWidth() - totalSpacing, rHeight);
        r++;
        sbRect = new Rectangle(dutyStatusSpacing, r * rHeight, this.getWidth() - totalSpacing, rHeight);
        r++;
        driveRect = new Rectangle(dutyStatusSpacing, r * rHeight, this.getWidth() - totalSpacing, rHeight);
        r++;
        onRect = new Rectangle(dutyStatusSpacing, r * rHeight, this.getWidth() - totalSpacing, rHeight);

        Rectangle rect = null;
        for (r = 0; r < gridArray.length; r++) {
            if (r == 0) {
                rect = offdutyRect;
            } else if (r == 1) {
                rect = sbRect;
            } else if (r == 2) {
                rect = driveRect;
            } else if (r == 3) {
                rect = onRect;
            }

            //I haven't actually derived any of these things, just my best guesses.
            int len = gridArray[r].length;
            int width = (int) (rect.getWidth() / len);
            rect.setSize((int) (width * len), (int) rect.getHeight());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //the center black bar for duty status "placeholders"
        g.setColor(Color.black);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawRect((int) offdutyRect.getX(), (int) offdutyRect.getY() + (int) offdutyRect.getHeight() / 2, (int) offdutyRect.getWidth(), 1);
        g.drawRect((int) sbRect.getX(), (int) sbRect.getY() + (int) sbRect.getHeight() / 2, (int) sbRect.getWidth(), 1);
        g.drawRect((int) driveRect.getX(), (int) driveRect.getY() + (int) driveRect.getHeight() / 2, (int) driveRect.getWidth(), 1);
        g.drawRect((int) onRect.getX(), (int) onRect.getY() + (int) onRect.getHeight() / 2, (int) onRect.getWidth(), 1);
        g.setColor(Color.pink);
        g.drawRect((int) offdutyRect.getX(), (int) offdutyRect.getY(), (int) offdutyRect.getWidth(), (int) offdutyRect.getHeight());
        g.drawRect((int) sbRect.getX(), (int) sbRect.getY(), (int) sbRect.getWidth(), (int) sbRect.getHeight());
        g.drawRect((int) driveRect.getX(), (int) driveRect.getY(), (int) driveRect.getWidth(), (int) driveRect.getHeight());
        g.drawRect((int) onRect.getX(), (int) onRect.getY(), (int) onRect.getWidth(), (int) onRect.getHeight());

        //draw the array
        g.setColor(Color.green);
        Rectangle rect = null;
        for (int r = 0; r < gridArray.length; r++) {
            if (r == 0) {
                rect = offdutyRect;
            } else if (r == 1) {
                rect = sbRect;
            } else if (r == 2) {
                rect = driveRect;
            } else if (r == 3) {
                rect = onRect;
            }

            //I haven't actually derived any of these things, just my best guesses.
            int len = gridArray[r].length;
            int width = (int) (rect.getWidth() / len);

            int height = (int) rect.getHeight() - 2;
            for (int c = 0; c < gridArray[r].length; c++) {
                if (gridArray[r][c] == 1) {
                    int x = (int) (rect.getX() + width * c);
                    int y = (int) rect.getY() + 2;
                    g.fillRect(x, y, width, height);
                }
            }
        }
    }

    //implement setSize
    //        public void setSize(Dimension d) {
    @Override
    public void doLayout() {

        if (gridArray == null) {

            int gridArrayColumns = 24 * 60 / delta;
            gridArray = new int[4][gridArrayColumns];
        }
        int r = 0;
        int rHeight = this.getHeight() / 4;
        offdutyRect = new Rectangle(dutyStatusSpacing, r * rHeight, (int) getWidth() - totalSpacing, rHeight);
        r++;
        sbRect = new Rectangle(dutyStatusSpacing, r * rHeight, (int) getWidth() - totalSpacing, rHeight);
        r++;
        driveRect = new Rectangle(dutyStatusSpacing, r * rHeight, (int) getWidth() - totalSpacing, rHeight);
        r++;
        onRect = new Rectangle(dutyStatusSpacing, r * rHeight, (int) getWidth() - totalSpacing, rHeight);

        Rectangle rect = null;
        for (r = 0; r < gridArray.length; r++) {
            if (r == 0) {
                rect = offdutyRect;
            } else if (r == 1) {
                rect = sbRect;
            } else if (r == 2) {
                rect = driveRect;
            } else if (r == 3) {
                rect = onRect;
            }

            //I haven't actually derived any of these things, just my best guesses.
            int len = gridArray[r].length;
            int width = (int) (rect.getWidth() / len);
            rect.setSize((int) (width * len), (int) rect.getHeight());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}