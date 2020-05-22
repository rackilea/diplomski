import java.awt.*;
import javax.swing.*;

public class HelloFrame {
    private void displayGUI() {
        JFrame frame = new JFrame("Hello Frame Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        JLabel label = new JLabel(
            "This is where I put something 3D", JLabel.CENTER);
        contentPane.add(label);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new HelloFrame().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}