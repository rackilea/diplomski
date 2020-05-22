import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LabelDemo
{
    public static void main(String[] args) {
        String[] labels = {
                "Found better price",
                "Not as shown on website",
                "Wrong product",
                "Damaged upon delivery",
                "None of the above"
        };
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String s: labels) {
            panel.add(new JLabel(s));
        }
        frame.add(panel);
        JButton button = new JButton("Select");
        button.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                if (panel.getComponentCount() > 0)
                    panel.remove(0);
                frame.repaint();
            }
        });
        frame.add(button, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}