public class Game extends JFrame
{
...
    public void paint (Graphics g){
        //Graphics2D g2 = (Graphics2D) g;
        board.paintComponent(g);
        board.getPieceAt(0,0).paintComponent(g);
    }
...
}