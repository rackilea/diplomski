import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
                frame.setLayout(new GridBagLayout());

                choiceLabel[0] = new JLabel("_");
                choiceLabel[1] = new JLabel("_");
                choiceLabel[2] = new JLabel("_");
                choiceLabel[3] = new JLabel("_");
                choiceLabel[4] = new JLabel("_");
                choiceLabel[5] = new JLabel("_");
                choiceLabel[6] = new JLabel("_");
                choiceLabel[7] = new JLabel("_");
                choiceLabel[8] = new JLabel("_");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                int col = 0;
                int row = 0;
                for (int i = 0; i < 9; i++) {
                    gbc.gridx = col;
                    gbc.gridy = row;
                    choiceLabel[i].setText("_");
                    choiceLabel[i].setHorizontalAlignment(JLabel.CENTER);
                    choiceLabel[i].setVerticalAlignment(JLabel.CENTER);
                    choiceLabel[i].setOpaque(true);
                    choiceLabel[i].setBackground(Color.RED);
                    frame.add(choiceLabel[i], gbc);
                    col++;
                    if (col > 2) {
                        col = 0;
                        row++;
                    }
                }
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}