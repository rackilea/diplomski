import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class SwingAnimationExample extends JPanel implements ActionListener {

    private static final int MAX_STATE = 4;

    private int state;

    public SwingAnimationExample() {
        // start timer to provide state change and repaint
        Timer t = new Timer(250, this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // painting depended  on the current state
        if (state == 0) {
            g.drawLine(0, 0, getWidth(), getHeight());
        } else if (state == 1) {
            g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        } else if (state == 2) {
            g.drawLine(getWidth(), 0, 0, getHeight());
        } else if (state == 3) {
            g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // change the current state and invoke repaint
        state++;
        if (state == MAX_STATE) {
            state = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame("Test timer");
        frm.add(new SwingAnimationExample());
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setSize(500, 400);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}