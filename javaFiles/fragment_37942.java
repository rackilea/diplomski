package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TryingProject2 implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TryingProject2());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Color Gradient Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createMainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel imageLabelPanel = new JPanel();
        imageLabelPanel.setLayout(new BorderLayout());

        final ImagePanel imagePanel = new ImagePanel(new Color(223, 130, 24,
                255), new Color(255, 255, 255, 255));
        imageLabelPanel.add(imagePanel, BorderLayout.CENTER);

        JLabel newLabel = new JLabel("Sample Label");
        newLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabelPanel.add(newLabel, BorderLayout.SOUTH);

        panel.add(imageLabelPanel, BorderLayout.CENTER);

        JButton button = new JButton("Change Color To Red");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imagePanel.setColor1(Color.RED);
                imagePanel.repaint();
                System.out.println("Button Pressed.");
            }
        });
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    public class ImagePanel extends JPanel {

        private static final long serialVersionUID = 6970287820048941335L;

        private Color color1;
        private Color color2;

        public ImagePanel(Color color1, Color color2) {
            this.color1 = color1;
            this.color2 = color2;
            this.setPreferredSize(new Dimension(200, 200));
        }

        public void setColor1(Color color1) {
            this.color1 = color1;
        }

        public void setColor2(Color color2) {
            this.color2 = color2;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            int w = getWidth();
            int h = getHeight();

            GradientPaint gp = new GradientPaint(0, 0, color1, w, 0, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }

    }

}