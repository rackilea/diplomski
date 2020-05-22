public class MyTable extends JTable implements MouseMotionListener {
    int mouseHoverRow = -1;

    public MyTable() {
           addMouseMotionListener(this);
    }

    //codes

    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,
            int vColIndex) {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        Color back = getSelectionBackground();
        int red = back.getRed();
        int green = back.getGreen();
        int blue = back.getBlue();
        if (rowIndex == mouseHoverRow) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(getBackground());
        }
        return c;
    }

    public void mouseMoved(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        mouseHoverRow = rowAtPoint(p);
    }