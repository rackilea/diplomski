import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingExample {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton but1 = new JButton("Add");
        but1.setText("Add Data");
        but1.setMnemonic('A');
        but1.setBorderPainted(false);
        but1.setBackground(Color.red);
        but1.setBorder(null);
        but1.setFocusable(false);
        but1.setMargin(new Insets(0, 0, 0, 0));
        //but1.setContentAreaFilled(false);
        panel.add(but1);
        JButton but2 = new JButton("Edit");
        but2.setText("Edit Data");
        but2.setMnemonic(KeyEvent.VK_E);
        panel.add(but2);
        JButton but3 = new JButton("Display");
        but3.setText("Display Data");
        but3.setMnemonic(KeyEvent.VK_D);
        panel.add(but3);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }
}