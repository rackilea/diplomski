import javax.swing.*;
import java.awt.event.*;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final JLabel label = new JLabel("Click on me and hold the mouse button down");
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(label);
        label.addMouseListener(new TimingMouseAdapter());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class TimingMouseAdapter extends MouseAdapter {
        private Timer timer;

        public void mousePressed(MouseEvent e) {
            timer = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Mouse still pressed...");
                }
            });
            timer.start();
        }

        public void mouseReleased(MouseEvent e) {
            if (timer != null) {
                timer.stop();
            }
        }

    }
}