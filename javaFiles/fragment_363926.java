public class GameMap extends JPanel{
  private JEditorPane status;
  private GameBoard board;
  public GameMap() {
    status= createStatusTextPane();
    board = new GameBoard();
    this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    this.add(board);
    this.add(status);
  }
  //...all of the other stuff in the class
  // note that you don't have to do anything special for painting in this class
}