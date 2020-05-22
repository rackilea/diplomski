import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TestJSeparator {

    public TestJSeparator() {
        JFrame frame = new JFrame(TestJSeparator.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel bigPanel = new JPanel(new GridBagLayout());
        GridBagConstraints lastConstraints = new GridBagConstraints();
        GridBagConstraints labelConstraints = new GridBagConstraints();
        GridBagConstraints separatorConstraint = new GridBagConstraints();
        lastConstraints.fill = GridBagConstraints.NONE;
        lastConstraints.anchor = GridBagConstraints.EAST;
        lastConstraints.weightx = 0.0;
        lastConstraints.gridwidth = GridBagConstraints.REMAINDER;
        lastConstraints.insets = new Insets(8, 8, 8, 8);

        labelConstraints = (GridBagConstraints) lastConstraints.clone();
        labelConstraints.weightx = 0.0;
        labelConstraints.fill = GridBagConstraints.NONE;
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.gridwidth = 1;

        separatorConstraint.weightx = 1.0;
        separatorConstraint.fill = GridBagConstraints.HORIZONTAL;
        separatorConstraint.gridwidth = GridBagConstraints.REMAINDER;

        JLabel label1 = new JLabel("1. TESTSTEP 0 TEST 0 DE");
        JLabel result1 = new JLabel(UIManager.getIcon("OptionPane.informationIcon"));
        JLabel label2 = new JLabel("2. TESTSTEP 0 TEST 1 DE");
        JLabel result2 = new JLabel(UIManager.getIcon("OptionPane.errorIcon"));
        bigPanel.add(label1, labelConstraints);
        bigPanel.add(result1, lastConstraints);
        bigPanel.add(new JSeparator(JSeparator.HORIZONTAL), separatorConstraint);
        bigPanel.add(label2, labelConstraints);
        bigPanel.add(result2, lastConstraints);
        bigPanel.add(new JSeparator(JSeparator.HORIZONTAL), separatorConstraint);
        frame.add(bigPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestJSeparator gui = new TestJSeparator();
            }
        });
    }
}