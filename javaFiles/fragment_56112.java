import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static tictactoe.TicTacToe.choiceLabel;

public class LayoutTicTacToe {

    public static void main(String[] args) {
        new LayoutTicTacToe();
    }

    public LayoutTicTacToe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(3, 3, 10, 10));

                choiceLabel[0] = new JLabel("_");
                choiceLabel[1] = new JLabel("_");
                choiceLabel[2] = new JLabel("_");
                choiceLabel[3] = new JLabel("_");
                choiceLabel[4] = new JLabel("_");
                choiceLabel[5] = new JLabel("_");
                choiceLabel[6] = new JLabel("_");
                choiceLabel[7] = new JLabel("_");
                choiceLabel[8] = new JLabel("_");

                for (int i = 0; i < 9; i++) {
                    choiceLabel[i].setText("_");
                    choiceLabel[i].setHorizontalAlignment(JLabel.CENTER);
                    choiceLabel[i].setVerticalAlignment(JLabel.CENTER);
                    choiceLabel[i].setOpaque(true);
                    choiceLabel[i].setBackground(Color.RED);
                    frame.add(choiceLabel[i]);
                }
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}