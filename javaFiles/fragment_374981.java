import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUI
{
    JFrame frame;
    JPanel squares[][];

    public GUI()
    {
        frame = new JFrame("Chess");
        squares = new JPanel[8][8];
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();

                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(Color.orange);
                }
                frame.add(squares[i][j]);
            }
        }

        String path = "/images/stackoverflow2.png";

        ImageIcon pawnW = new ImageIcon(getClass().getResource(path));
        ImageIcon knightW = new ImageIcon(getClass().getResource(path));
        ImageIcon bishopW = new ImageIcon(getClass().getResource(path));
        ImageIcon rookW = new ImageIcon(getClass().getResource(path));
        ImageIcon queenW = new ImageIcon(getClass().getResource(path));
        ImageIcon kingW = new ImageIcon(getClass().getResource(path));

        ImageIcon pawnB = new ImageIcon(getClass().getResource(path));
        ImageIcon knightB = new ImageIcon(getClass().getResource(path));
        ImageIcon bishopB = new ImageIcon(getClass().getResource(path));
        ImageIcon rookB = new ImageIcon(getClass().getResource(path));
        ImageIcon queenB = new ImageIcon(getClass().getResource(path));
        ImageIcon kingB = new ImageIcon(getClass().getResource(path));

        squares[0][0].add(new JLabel(rookW));
        squares[1][0].add(new JLabel(knightW));
        squares[2][0].add(new JLabel(bishopW));
        squares[3][0].add(new JLabel(queenW));
        squares[4][0].add(new JLabel(kingW));
        squares[5][0].add(new JLabel(bishopW));
        squares[6][0].add(new JLabel(knightW));
        squares[7][0].add(new JLabel(rookW));

        squares[0][7].add(new JLabel(rookB));
        squares[1][7].add(new JLabel(knightB));
        squares[2][7].add(new JLabel(bishopB));
        squares[3][7].add(new JLabel(queenB));
        squares[4][7].add(new JLabel(kingB));
        squares[5][7].add(new JLabel(bishopB));
        squares[6][7].add(new JLabel(knightB));
        squares[7][7].add(new JLabel(rookB));

        for (int i = 0; i < 8; i++)
        {
            squares[i][4].add(new JLabel (pawnW));
            squares[i][6].add(new JLabel (pawnB));
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new GUI();
            }
        });
    }
}