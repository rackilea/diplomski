import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBindings extends JFrame {

    private static final int D_W = 500;
    private static final int D_H = 200;
    int x = 0;
    int y = 0;

    DrawPanel drawPanel = new DrawPanel();

    public KeyBindings() {
        ActionListener listener = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (x >= D_W) {
                    x = 0;
                    drawPanel.repaint();
                } else {
                    x += 10;
                    drawPanel.repaint();
                }
            }
        };
        Timer timer = new Timer(100, listener);
        timer.start();
        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 50);
        }

        public Dimension getPreferredSize() {
            return new Dimension(D_W, D_H);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeyBindings();
            }
        });
    }
}