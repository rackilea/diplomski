import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BallTask {

    public static boolean run = false;
    private Timer timer;
    private BallPanel ballPanel = new BallPanel();

    public BallTask() {
        timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ballPanel.x < 0 || ballPanel.x > ballPanel.getWidth()) {
                    ballPanel.dx = -ballPanel.dx;
                }
                if (ballPanel.y < 0 || ballPanel.y > ballPanel.getHeight()) {
                    ballPanel.dy = -ballPanel.dy;
                }
                // Adjust ball position
                ballPanel.x += ballPanel.dx;
                ballPanel.y += ballPanel.dy;
                ballPanel.repaint();
            }
        });
        JPanel buttons = new JPanel();
        JButton stop = new JButton("STOP");
        buttons.add(stop);
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        JButton go = new JButton("GO");
        buttons.add(go);
        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(ballPanel);
        mainPanel.add(buttons, BorderLayout.SOUTH);

        JFrame window = new JFrame();
        window.add(mainPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    private class BallPanel extends JPanel {

        private int x;
        private int y;
        int dx = 4; // Increment on ball's x-coordinate
        int dy = 4; // Increment on ball's y-coordinate
        int radius = 15; // Ball radius

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(x, y, 30, 30);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 300);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BallTask();
            }
        });
    }
}