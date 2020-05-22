import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FrameClass extends JFrame {
    JPanel panel;

    JComboBox<String> box;

    String[] s = {"1", "2", "3", "4", "5"};

    String[] s1 = {"0", "1", "2", "3", "4", "5"};

    public FrameClass() {
        panel = new JPanel();
        box = new JComboBox(s);
        JComboBox[] adults = new JComboBox[5];
        JComboBox[] children = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            adults[i] = new JComboBox<>(s);
            children[i] = new JComboBox<>(s1);
        }

        panel.add(box, BorderLayout.CENTER);
        JPanel nested = new JPanel();
        add(nested, BorderLayout.EAST);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nested.removeAll();
                nested.setLayout(new GridLayout(box.getSelectedIndex() + 1, 2));
                for (int i = 0; i <= box.getSelectedIndex(); i++) {
                    nested.add(adults[i]);
                    nested.add(children[i]);
                }
                getContentPane().revalidate();
                getContentPane().repaint();
                pack();
            }
        });
        add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new FrameClass();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); // center the window
        frame.setVisible(true);
    }
}