import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JOptionPanePrintingInColumns {

    private JPanel pane;
    private String[] oneDArray = new String[] {"1000", "10000", "99999", "23000", "100000"};
    private String[][] twoDArray = new String[][] {
        {"1000", "10000", "99999", "23000", "100000"},
        {"1000", "10000", "99999", "23000", "100000"}, 
        {"1000", "10000", "99999", "23000", "100000"},
        {"1000", "10000", "99999", "23000", "100000"}, 
        {"1000", "10000", "99999", "23000", "100000"}
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new JOptionPanePrintingInColumns()::createAndShowGui);
    }

    private void createAndShowGui() {
        //For the 1D Array
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 5, 50, 10));
        for (int i = 0; i < oneDArray.length; i++) {
            JLabel label = new JLabel(oneDArray[i]);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pane.add(label);
        }
        JOptionPane.showMessageDialog(new JFrame(), pane);

        //For the 2D array
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 5, 50, 10));
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                JLabel label = new JLabel(twoDArray[i][j]);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pane.add(label);
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), pane);
    }
}