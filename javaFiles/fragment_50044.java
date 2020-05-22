import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingTest {

    public static void main(String[] args) {
        final JPanel panel = new JPanel(new GridBagLayout());

        for (int i = 0; i < 25; i++) {
            JTextField field = new JTextField("Field " + i, 20);

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridy = i;

            panel.add(field, constraints);
        }

        final JScrollPane scrollPane = new JScrollPane(panel);

        JButton removeButton = new JButton("Remove Field");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (panel.getComponentCount() >= 1) {
                    panel.remove(panel.getComponentCount() - 1);
                    scrollPane.revalidate();
                    scrollPane.repaint();
                }
            }
        });


        JFrame frame = new JFrame("Swing Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLocation(200, 200);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(removeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}