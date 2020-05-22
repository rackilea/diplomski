import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Test {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        p.setBackground(Color.PINK);

        new MouseMovementMonitor(p, 500, new MouseMovementListener() {
            @Override
            public void movementOccured(MouseMovementEvent e) {
                System.out.println("Movement Duration in nanos: " + e.getMotionDurationInNanos());              
            }
        });

        JFrame f = new JFrame();
        f.setBounds(200,200,200,200);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
}