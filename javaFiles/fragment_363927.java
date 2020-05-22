public class GameBoard extends JPanel {
  //...all of the other stuff in the class
  public void paintComponent(Graphics g) {
    for (int row = 0; row < numrows; row++)
      for (int column = 0; column < numcolumns ; column ++)
        paintCell(g, row, column);
  }
}