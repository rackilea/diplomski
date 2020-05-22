import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class ComboBoxRadioButton extends JRadioButton {

    private JLabel beforeText, afterText;
    private JComboBox comboBox;

    public ComboBoxRadioButton(String beforeTxt, JComboBox comboBox, 
                                             String afterText) {
        this.comboBox = comboBox;
        this.beforeText = new JLabel("    " + beforeTxt);
        this.afterText = new JLabel(afterText);
        comboBox.setSelectedIndex(0);
        setLayout(new FlowLayout());
        setModel(new JToggleButton.ToggleButtonModel());
        add(this.beforeText);
        add(this.comboBox);
        add(this.afterText);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPane = new JPanel();
        ButtonGroup group = new ButtonGroup();
        AbstractButton b2 = new JRadioButton("Java Swing");
        AbstractButton b3 = new ComboBoxRadioButton(
                "It's gonna be a", new JComboBox(new String[] { "good", "bad",
                "rainy" }), "day!");
        AbstractButton b4 = new JRadioButton("After the combo");
        group.add(b2);
        group.add(b3);
        group.add(b4);
        mainPane.add(b2);
        mainPane.add(b3);
        mainPane.add(b4);
        f.add(mainPane);
        f.pack();
        f.setVisible(true);
    }
}