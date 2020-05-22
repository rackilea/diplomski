import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        // Show GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI() {

                    @Override
                    public void execute(Object result) {
                        System.out.println("You have selected " + result);
                    }

                };
                gui.setVisible(true);
            }
        });

        // Kick off a process based on the user's selection
    }
}

interface Callback {
    void execute(Object result);
}

abstract class GUI extends JFrame implements Callback {
    private static final long serialVersionUID = 1L;

    public GUI() {
        setTitle("GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 100);
        setLocationRelativeTo(null);

        JPanel cp = new JPanel();
        cp.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(cp);

        JLabel lbl = new JLabel("Selection:");
        cp.add(lbl);

        final JComboBox comboBox = new JComboBox(new String[] { "One", "Two", "Three" });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                // Share the selected item with Main.class
                execute(comboBox.getSelectedItem());
            }
        });
        cp.add(comboBox);
    }

}