import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new VendingMachinePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class VendingMachinePane extends JPanel {

        public VendingMachinePane() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Cover");
            // Demonstration purpose only
            label.setPreferredSize(new Dimension(200, 400));
            label.setOpaque(true);
            label.setBackground(Color.BLUE);

            add(label);

            JPanel optionsPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;

            optionsPane.setBackground(Color.DARK_GRAY);
            optionsPane.add(new JLabel("Coin Slot"), gbc);
            optionsPane.add(makeButton("Pepsi"), gbc);
            optionsPane.add(makeButton("Diet Pepsi"), gbc);
            optionsPane.add(makeButton("Slice"), gbc);
            optionsPane.add(makeButton("Dr Pepper"), gbc);
            optionsPane.add(makeButton("Lipton"), gbc);
            optionsPane.add(makeButton("Mountain Dew"), gbc);
            optionsPane.add(makeButton("Schweppes"), gbc);
            gbc.weighty = 1;
            optionsPane.add(makeButton("Pepsi"), gbc);

            add(optionsPane, BorderLayout.LINE_END);
        }

        protected JButton makeButton(String text) {
            JButton btn = new JButton(text);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setMargin(new Insets(4, 4, 4, 4));
            btn.setOpaque(false);
            return btn;
        }

    }

}