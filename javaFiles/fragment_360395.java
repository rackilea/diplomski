import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonsIcon extends JFrame {

    private static final long serialVersionUID = 1L;
    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ButtonsIcon t = new ButtonsIcon();
            }
        });
    }

    public ButtonsIcon() {
        setLayout(new GridLayout(2, 2, 4, 4));

        JButton button = new JButton();
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setFocusable(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setIcon((errorIcon));
        button.setRolloverIcon((infoIcon));
        button.setPressedIcon(warnIcon);
        button.setDisabledIcon(warnIcon);
        add(button);

        JButton button1 = new JButton();
        button1.setBorderPainted(false);
        button1.setBorder(null);
        button1.setFocusable(false);
        button1.setMargin(new Insets(0, 0, 0, 0));
        button1.setContentAreaFilled(false);
        button1.setIcon((errorIcon));
        button1.setRolloverIcon((infoIcon));
        button1.setPressedIcon(warnIcon);
        button1.setDisabledIcon(warnIcon);
        add(button1);
        button1.setEnabled(false);

        final JToggleButton toggleButton = new JToggleButton();
        toggleButton.setIcon((errorIcon));
        toggleButton.setRolloverIcon((infoIcon));
        toggleButton.setPressedIcon(warnIcon);
        toggleButton.setDisabledIcon(warnIcon);
        toggleButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton.isSelected()) {
                } else {
                }
            }
        });
        add(toggleButton);

        final JToggleButton toggleButton1 = new JToggleButton();
        toggleButton1.setIcon((errorIcon));
        toggleButton1.setRolloverIcon((infoIcon));
        toggleButton1.setPressedIcon(warnIcon);
        toggleButton1.setDisabledIcon(warnIcon);
        toggleButton1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (toggleButton1.isSelected()) {
                } else {
                }
            }
        });
        add(toggleButton1);
        toggleButton1.setEnabled(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}