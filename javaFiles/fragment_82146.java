@Override
public void mouseClicked(MouseEvent e) {
    int row, col; // the row and column in the grid of squares where the user clicked.
    row = findRow( e.getY() ); col = findColumn( e.getX() );  //find the location of cells clicked

    System.out.println("Cell color: " + circleColor[row][col]); //will let you see whats happening
    if (circleColor[row][col] == null) {
        circleColor[row][col] = new Color(0,223,197);
    } else {
        circleColor[row][col] = null;
    }

    repaint(); // redraw the panel by calling the paintComponent method.
}