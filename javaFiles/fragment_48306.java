import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestPanel extends JPanel {

    private double angle = 0;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D en = (Graphics2D) g;
        AffineTransform tf = AffineTransform.getTranslateInstance(-getWidth() / 2, -getHeight() / 2);
        tf.preConcatenate(AffineTransform.getRotateInstance(Math.toRadians(angle)));
        tf.preConcatenate(AffineTransform.getTranslateInstance(getWidth() / 2, getHeight() / 2));
        en.setTransform(tf);
        GradientPaint gp = new GradientPaint(25, 25, Color.red, 15, 25, Color.orange, true);
        en.setPaint(gp);
        en.setStroke(new BasicStroke(4.0F));
        en.drawLine(400, 400, 600, 600);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    public void setAngle(double angle) {
        this.angle = angle;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                final TestPanel panel = new TestPanel();
                final JSlider slider = new JSlider(0, 360);
                slider.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        panel.setAngle(slider.getValue());
                    }
                });
                slider.setValue(0);
                frame.add(panel);
                frame.add(slider, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}