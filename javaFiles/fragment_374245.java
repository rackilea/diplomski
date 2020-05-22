import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final JPanel panel = new JPanel(new GridLayout(3, 3));

        final JTextField textfield = new JTextField("asdf");
        final JButton button = new JButton("asdf");
        final JCheckBox checkbox = new JCheckBox("asdf");
        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        final JLabel label = new JLabel("asdf");

        panel.add(textfield);
        panel.add(button);
        panel.add(checkbox);
        panel.add(spinner);
        panel.add(label);
        // fill in some random stuff
        for (int i = 0; i < 4; i++) {
            panel.add(new JLabel("asdf"));
        }

        frame.setContentPane(panel);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean toggle = true;
                while (true) {
                    toggle = !toggle;
                    Set<Component> enableList = new HashSet<Component>();
                    Set<Component> disableList = new HashSet<Component>();
                    enableList.add(textfield);
                    enableList.add(spinner);
                    disableList.add(checkbox);
                    setEnableAllRec(panel, toggle, disableList, enableList);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
        frame.setVisible(true);
    }

    public static void setEnableAllRec(Container root, boolean defaultState, Set<Component> disableList, Set<Component> enableList) {
        if (root == null) {
            return;
        }
        for (Component c : root.getComponents()) {
            if (disableList != null && disableList.contains(c)) {
                c.setEnabled(false);
                disableList.remove(c);
            } else if (enableList != null && enableList.contains(c)) {
                c.setEnabled(true);
                enableList.remove(c);
            } else {
                c.setEnabled(defaultState);
                if (c instanceof Container) {
                    setEnableAllRec((Container) c, defaultState, disableList, enableList);
                }
            }
        }
    }
}