import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DiceRoll {

    public static void main(String[] args) {
        new DiceRoll();
    }

    public DiceRoll() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new DicePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DicePane extends JPanel {

        private JLabel diceRoll;
        private JButton rollDice;

        public DicePane() {
            setLayout(new BorderLayout());

            diceRoll = new JLabel();
            Font font = diceRoll.getFont();
            diceRoll.setFont(font.deriveFont(128f));
            diceRoll.setHorizontalAlignment(JLabel.CENTER);
            add(diceRoll);

            rollDice = new JButton("Papper needs a new pair of shoes");
            rollDice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int roll = (int) (Math.round((Math.random() * 5) + 1));
                    diceRoll.setText(Integer.toString(roll));
                }
            });

            add(rollDice, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }        
}