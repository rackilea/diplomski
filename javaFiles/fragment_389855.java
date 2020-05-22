import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ottp
 * @version 1.0
 */
public class CardPanel extends JPanel {

    final private JLabel label;
    private JButton addSetButton;
    private JPanel actives, optionsPanel,cardPanel, flashCardsPanel, bottomPanel;

    public CardPanel() {

        actives = new JPanel();
        actives.setPreferredSize(new Dimension(1000, 50));
        actives.setBackground(Color.BLUE);
        this.add(actives);

        label   = new JLabel();
        actives.add(label);

        optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(200, 350));
        optionsPanel.setBackground(Color.cyan);
        this.add(optionsPanel);

        cardPanel = new JPanel();
        cardPanel.setPreferredSize(new Dimension(580, 350));
        cardPanel.setBackground(Color.green);
        this.add(cardPanel);

        flashCardsPanel = new JPanel();
        flashCardsPanel.setPreferredSize(new Dimension(200, 350));
        flashCardsPanel.setBackground(Color.white);
        this.add(flashCardsPanel);


        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setPreferredSize(new Dimension(1000, 400));
        bottomPanel.setBackground(Color.black);
        this.add(bottomPanel);

        this.addSetButton = new JButton("Add Set");
        addSetButton.setPreferredSize(new Dimension(150, 30));
        optionsPanel.add(addSetButton, BorderLayout.WEST);
        addSetButton.addActionListener(new ButtonListener());



    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setForeground(Color.WHITE);
            label.setText("Active set: " + e.getActionCommand());

            if(e.getSource().equals(addSetButton)) {
                getSetInfo();
            }
        }

    }

    private void getSetInfo() {
        String newSetName = 
                JOptionPane.showInputDialog(cardPanel, "Enter the name of your set", JOptionPane.INFORMATION_MESSAGE);

        JButton newSet = new JButton(newSetName);
        newSet.setBackground(Color.WHITE);
        newSet.addActionListener(new ButtonListener());

        bottomPanel.add(newSet);
        bottomPanel.revalidate();
    }
}