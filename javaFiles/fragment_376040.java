import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleAnimation extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;
    private static final int TIMER_DELAY = 20;
    private Player2 playerLeft = new Player2(5, 150, Color.RED);
    private Player2 playerRight = new Player2(150, 150, Color.BLUE);

    public SimpleAnimation() {
        playerLeft.setySpeed(1);
        playerRight.setySpeed(-1);
        new Timer(TIMER_DELAY, new TimerListener()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        playerLeft.draw(g);
        playerRight.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            playerRight.move();
            playerLeft.move();
            repaint();
        }
    }

    private static void createAndShowGui() {
        SimpleAnimation mainPanel = new SimpleAnimation();

        JFrame frame = new JFrame("SimpleAnimation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}