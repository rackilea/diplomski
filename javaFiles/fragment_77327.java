import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Gameplay extends JFrame {

    private int size;
    GameButton[][] butt;
    private JPanel contentPane1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gameplay frame2 = new Gameplay("MEDIO");
                frame2.setVisible(true);
            }
        });
    }

    public Gameplay(String dificuldade) {
        this.setTitle("Minesweeper");
        // instead of doing this, which is no more than a guess, 
        // add the components then pack() the frame.
        //setBounds(100, 100, 450, 300);
        contentPane1 = new JPanel();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane1.setBackground(Color.WHITE);
        contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane1);
        setLocationRelativeTo(null);

        if (dificuldade.contentEquals("MEDIO")) {
            size = 16;
        }
        butt = new GameButton[size][size];

        contentPane1.setLayout(new java.awt.GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                butt[i][k] = new GameButton(i, k);
                contentPane1.add(butt[i][k]);
            }
        }
        this.pack();
    }

    class GameButton extends JButton {

        int row, col;

        public GameButton(int row, int col) {
            this.row = row;
            this.row = col;
        }
    }
}