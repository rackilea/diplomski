public class MainFrame extends JFrame {
    public MainFrame() {
        GridPainter gp = new GridPainter(5,5);
        gp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // onLeftButtonClick
                    gp.selectCell(e.getX(), e.getY()); 
                } else { 
                    // onWheelButton/RightButtonClick
                    gp.unselectCell(e.getX(), e.getY()); 
                }
            }
        });
        add(gp);
        setSize(new Dimension(500,500));
        setVisible(true);
    }
}

public class GridPainter extends JComponent {
    private final int rows;
    private final int columns;
    private boolean[][] isSelected; // selection state of cells

    public GridPainter(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        isSelected = new boolean[rows][columns];
    }

    private int getRowSize() {return getHeight() / rows;}
    private int getColSize() {return getWidth() / columns;}

    private int[] resolveIndices(int x, int y) {
        int i = y / getRowSize();
        int j = x / getColSize();
        return new int[] {i, j};
    }

    public void selectCell(int x, int y) {
        int[] indices = resolveIndices(x, y);
        int i = indices[0];
        int j = indices[1];
        isSelected[i][j] = true;
        repaint();
    }
    public void unselectCell(int x, int y) {
        int[] indices = resolveIndices(x, y);
        int i = indices[0];
        int j = indices[1];
        isSelected[i][j] = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = this.getWidth();
        int height = this.getHeight();

        // draw rows
        int rowSize = getRowSize();
        for (int i = 0; i < columns; i++) {
            int yOffset = i * rowSize;
            g2.drawLine(0, yOffset, width, yOffset);
        }

        // draw lines
        int colSize = getColSize();
        for (int j = 0; j < rows; j++) {
            int xOffset = j * colSize;
            g2.drawLine(xOffset, 0, xOffset, height);
        }

        // fill selected cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (isSelected[i][j]) {
                    Color oldColor = g2.getColor();
                    g2.setColor(Color.BLUE);
                    int x = j * colSize;
                    int y = i * rowSize;
                    int w = colSize;
                    int h = rowSize;
                    g2.fillRect(x, y, w, h);
                    g2.setColor(oldColor);
                }
            }
        }
    }
}