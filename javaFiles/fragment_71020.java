import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class myTest {

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton button1 = new JButton();

        final JLabel label = new JLabel("Hello World");

        label.setVisible(false);
        frame.add(panel);
        panel.add(button1);
        panel.add(label);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                //JOptionPane.showMessageDialog(frame.getComponent(0), "Hello World");
                label.setVisible(true);
            }
        });

    }

}