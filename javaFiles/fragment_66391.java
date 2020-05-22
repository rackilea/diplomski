public class Grid extends JPanel {
    public static final int GRID_SIZE = 10;

    public Grid() {
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                final Cell cell = new Cell(x, y);
                add(cell);
                cell.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        click(e, cell);
                    }
                    // other mouse listener functions
                });
            }
        }        
    }

    public void click(MouseEvent e, Cell cell) {
        // handle the event, for instance
        cell.setBackground(Color.blue);
    }

    // handlers for the other mouse events
}