package gui;

import javax.swing.*;
import java.awt.*;

public class GUI {
 public static void main(String[] args) {
    /* step 1 */
    JFrame frame = new JFrame();
    frame.setSize(new Dimension(300, 500));
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /* step 2 */
    JPanel panel = new JPanel();
    panel.setBackground(Color.GRAY);

    /* step 3 */
    JButton button = new JButton("Submit");
    panel.add(button);

    JTextField txtnum1 = new JTextField();
    txtnum1.setPreferredSize(new Dimension(30, 50));
    panel.add(txtnum1);

    JButton button2 = new JButton("Clear");
    panel.add(button2);

    /* step 4 */
    frame.getContentPane().add(panel);
    /* step 5 */
    frame.setVisible(true);
 }

}