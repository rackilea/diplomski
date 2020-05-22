import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setBackground(Color.BLACK);
            JFrame frame = new JFrame();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //frame.pack();
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}