package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Manyak implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Manyak());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Hello Word Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel();

        frame.add(drawingPanel);
        frame.pack();
        frame.setVisible(true);

        new Thread(new Delay(drawingPanel)).start();
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -685508126882892538L;

        private Color color;

        public DrawingPanel() {
            this.setPreferredSize(new Dimension(400, 400));
            this.color = Color.BLUE;
        }

        public void setColor(Color color) {
            this.color = color;
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Hello World!", 120, 200);
        }

    }

    public class Delay implements Runnable {

        private DrawingPanel drawingPanel;

        public Delay(DrawingPanel drawingPanel) {
            super();
            this.drawingPanel = drawingPanel;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {

            }

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    drawingPanel.setColor(Color.WHITE);
                }

            });

        }

    }
}