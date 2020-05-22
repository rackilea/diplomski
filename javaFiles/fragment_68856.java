package keymovement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

public class TestMovingObject {

    static class Envelope {
        double x;
        double y;

        void setPosition(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class DrawArea extends JPanel {

        Envelope envelope = new Envelope();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            int x = (int) Math.round(envelope.x);
            int y = (int) Math.round(envelope.y);
            g.drawRect(x, y, 20, 20);
        }

        public Envelope getEnvelope() {
            return envelope;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                JFrame window = new JFrame("Moving box");
                window.setPreferredSize(new Dimension(500, 400));
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final DrawArea mainArea = new DrawArea();
                window.add(mainArea);
                window.pack();

                window.setLocationRelativeTo(null);
                window.setVisible(true);

                int delay = 20; // execute every 20 milliseconds i.e. 50 times per second  

                Timer timer = new Timer(delay, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Envelope envelope = mainArea.getEnvelope();
                        double x = envelope.x + 1;  // use smaller increments depending on the desired speed
                        double y = 0.5 * x + 2;     // moving along the line y = 0.5 * x + 2
                        envelope.setPosition(x, y);
                        mainArea.repaint();
                    }
                });
                timer.setRepeats(true);
                timer.start();

            }
        });
    }

}