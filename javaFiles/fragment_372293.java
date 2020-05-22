package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimplePainting implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("Simple Painting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PaintPanel paintPanel = new PaintPanel();
        frame.add(paintPanel);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimplePainting());
    }

    class PaintPanel extends JPanel {

        private static final long serialVersionUID = 
                -5950526117015270963L;

        private Ellipse2D myEllipse = 
                new Ellipse2D.Double(20, 20, 100, 100);

        private String myText = "Testing, one, two, three";

        public PaintPanel() {
            this.setPreferredSize(new Dimension(400, 200));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setXORMode(Color.WHITE);

            g2d.setColor(Color.RED);
            g2d.fill(myEllipse);

            g2d.setColor(Color.CYAN);
            g2d.drawString(myText, 70, 70);

        }
    }

}