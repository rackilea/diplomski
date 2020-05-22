package com.ggl.testing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PartialRepaint implements Runnable {
    private DrawBoard dr = new DrawBoard();
    private int x, y, dx, dy;
    private boolean boo = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PartialRepaint());
    }

    @Override
    public void run() {
        KListen listen = new KListen();
        dr.addKeyListener(listen);
        dr.setFocusable(true);

        JFrame frame = new JFrame();
        frame.setTitle("KeyListening");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(dr);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class DrawBoard extends JPanel {

        private static final long serialVersionUID = 6566116168990163107L;

        public DrawBoard() {
            this.setPreferredSize(new Dimension(400, 400));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (boo) {
                // super.paintComponent(g);
                x = dr.getWidth() / 2;
                y = dr.getHeight() / 2;
            }
            int x1 = x + dx;
            int y1 = y + dy;
            g.drawLine(x, y, x1, y1);
            x = x1;
            y = y1;
        }
    }

    public class KListen implements KeyListener {
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'a') {
                dx = -10;
                dy = 0;
            }
            if (e.getKeyChar() == 'd') {
                dx = 10;
                dy = 0;
            }
            if (e.getKeyChar() == 'w') {
                dx = 0;
                dy = -10;
            }
            if (e.getKeyChar() == 's') {
                dx = 0;
                dy = 10;
            }
            boo = false;
            dr.repaint();
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

    }
}