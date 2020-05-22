package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PyramidSoupCans implements Runnable {

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PyramidSoupCans());
    }

    @Override
    public void run() {
        frame = new JFrame("Pyramid Soup Cans");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel(300, 500);
        frame.add(panel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -4147433638611078320L;

        public DrawingPanel(int width, int height) {
            this.setPreferredSize(new Dimension(width, height));
            this.setBackground(new Color(219, 204, 186));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int sizeX = 225;
            int sizeY = 340;
            int cornerX = 37;
            int cornerY = 80;

            g.setColor(new Color(138, 138, 138));
            g.fillRoundRect(cornerX, 246, sizeX, 180, 150, 45);
            g.setColor(new Color(243, 243, 243));
            g.fillRoundRect(cornerX, cornerY, sizeX, sizeY, 150, 45);
            g.setColor(new Color(162, 22, 5));
            g.fillRoundRect(cornerX, 70, sizeX, 190, 150, 45);
            g.setColor(new Color(138, 138, 138));
            g.fillOval(cornerX, 65, sizeX, 45);
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 45));
            g.drawString("Campbell's", 45, 150);
            g.setFont(new Font("SanSerif", Font.BOLD, 20));
            g.drawString("CONDENSED", 85, 200);
            g.setColor(new Color(162, 22, 5));
            g.setFont(new Font("SanSerif", Font.BOLD, 40));
            g.drawString("TOMATO", 60, 360);
            g.setFont(new Font("Serif", Font.BOLD, 40));
            g.setColor(new Color(157, 131, 82));
            g.fillOval(113, 223, 70, 70);
            g.drawString("SOUP", 95, 410);
        }
    }
}