class Cell extends JPanel {
int row, col;
public static final int STATE_DEAD = 0;
public static final int STATE_ALIVE = 1;
int state = STATE_DEAD;

public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    // MouseAdapter tells a component how it should react to mouse events
    MouseAdapter mouseAdapter = new MouseAdapter() {
        // using mouseReleased because moving the mouse slightly
        // while clicking will register as a drag instead of a click
        @Override
        public void mouseReleased(MouseEvent e) {
            flip();
            repaint(); // redraw the JPanel to reflect new state
        }
    };
    // assign that behavior to this JPanel for mouse button events
    addMouseListener(mouseAdapter);
}

// Override this method to change drawing behavior to reflect state
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // fill the cell with black if it is dead
    if(state == STATE_DEAD) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

public void flip() {
    if(state == STATE_DEAD) {
        state = STATE_ALIVE;
    } else {
        state = STATE_DEAD;
    }
}