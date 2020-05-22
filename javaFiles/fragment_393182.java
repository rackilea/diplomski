import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CreditGraphics {

    public String cardNum;
    public JFrame frame;
    public JPanel panel;
    public JLabel label;
    public JTextField text;

    public CreditGraphics() {
        frame = new JFrame("HI");
        panel = new JPanel();
        label = new JLabel("Welcome to MES Banking!");

        text = new JTextField();

        panel.add(label);
        panel.add(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardNum = text.getText();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CreditGraphics();
            }
        });
    }
}