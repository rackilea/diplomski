import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    private final JLabel[] label = new JLabel[5];
    private final JButton[] button = new JButton[5];

    public Test() {
        JPanel mainPanel = new JPanel(new GridLayout(0,2));
        for (int counter = 0; counter < label.length; counter++) {
            label[counter] = new JLabel("Label " + counter);
            button[counter] = new JButton("Button " + counter);
            button[counter].addActionListener(new MyActionListener("Row " + counter));
            mainPanel.add(label[counter]);
            mainPanel.add(button[counter]);
        }
        this.add(mainPanel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Test run = new Test();
                run.pack();
                run.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                run.setVisible(true);
            }
        });
    }

    private class MyActionListener implements ActionListener {

        String text;

        public MyActionListener(String text) {
            this.text = text;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println(text);
        }
    }
}