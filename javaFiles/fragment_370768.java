import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

public class BufferStrategyDemo extends JFrame {
    private BufferStrategy bufferStrategy;
    private Canvas gameField;
    private JScrollBar scroll;

    public BufferStrategyDemo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(800, 600));

        gameField = new Canvas();
        gameField.setIgnoreRepaint(true);
        gameField.setPreferredSize(new Dimension(800, 580));
        getContentPane().add(gameField, BorderLayout.CENTER);

        scroll = new JScrollBar(JScrollBar.HORIZONTAL);
        scroll.setPreferredSize(new Dimension(800, 20));
        scroll.setMaximum(1400 - 800); // image width - viewport width
        getContentPane().add(scroll, BorderLayout.SOUTH);

        this.pack();

        gameField.createBufferStrategy(2);
        bufferStrategy = gameField.getBufferStrategy();

        new Renderer().start();
    }

    private class Renderer extends Thread {
        private BufferedImage imageOfGameField;

        public Renderer() {
            // NOTE: image size is fixed now, but better to bind image size to the size of viewport
            imageOfGameField = new BufferedImage(1400, 580, BufferedImage.TYPE_INT_ARGB);
        }

        public void run() {
            while (true) {
                Graphics g = null;
                try {
                    g = bufferStrategy.getDrawGraphics();
                    drawSprites(g);
                } finally {
                    g.dispose();
                }

                bufferStrategy.show(); 
                Toolkit.getDefaultToolkit().sync();

                try {
                    Thread.sleep(1000 / 60);
                } catch (InterruptedException ie) {
                }
            }
        }

        private void drawSprites(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            Graphics g2d2 = imageOfGameField.createGraphics();
            g2d2.setColor(Color.YELLOW); // clear background
            g2d2.fillRect(0, 0, 1400, 580); // again, fixed width/height only for SSCCE
            g2d2.setColor(Color.BLACK);

            int shift = -scroll.getValue(); // here it is - get shift value

            g2d2.fillRect(100 + shift, 100, 20, 20); // i am ugly black sprite
            g2d2.fillRect(900 + shift, 100, 20, 20); // i am other black sprite
                                                     // located outside of default view

            g2d.drawImage(imageOfGameField, 0, 0, null);

            g2d2.dispose();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BufferStrategyDemo mf = new BufferStrategyDemo();
                mf.setVisible(true);
            }
        });
    }
}