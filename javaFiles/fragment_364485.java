public class myGame extends JFrame { 
  private Board board;
  public myGame() { 
    //...snip...

    statsBar = new JLabel(""); 
    board= Board(statsBar ) // initializing Board Class . you can do your self 

    add(statsBar, BorderLayout.SOUTH); 
    add(new Board(statsBar)); 
    setResizable(false); 
    setVisible(true);
    addMenubar();
} 

private void addMenubar() {
    JMenuBar menubar = new JMenuBar();
    JMenu topMnuGame = new JMenu("File");
    JMenuItem mnuSolve = new JMenuItem("Solve");
    mnuSolve.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

          // freshGame.solveGame();
          // this is where I need to call the solveGame function
          // for the "freshGame" instance.
          solveGame();

          // now you can call 
            board.solveGame();
        }
    });
    topMnuGame.add(mnuSolve);
    menubar.add(topMnuGame);
 }
public static void main(String[] args) { 
    myGame freshGame = new myGame();
 }
}