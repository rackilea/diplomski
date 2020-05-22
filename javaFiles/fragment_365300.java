import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestMove extends JPanel{
    public TestMove() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("label"));
        panel.add(new JButton("button"));

        panel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        panel.setBounds(50, 50, 200, 50);

        add(panel);

        ComponentMover cm = new ComponentMover();
        cm.registerComponent(panel);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {   
            public void run() {   
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                TestMove panel = new TestMove();
                frame.add(panel);
                frame.pack();

                frame.setVisible(true);
            }
        });

    }
}