import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class ScrollEg extends JPanel {
    public ScrollEg() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(new InnerPanel());

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(650, 500);
    }

    private static class InnerPanel extends JPanel {
        private static final int PREF_W = 1000;
        private static final Color COLOR_1 = Color.RED;
        private static final Color COLOR_2 = Color.BLUE;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(PREF_W, PREF_W);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new GradientPaint(0, 0, COLOR_1, 100, 100, COLOR_2, true));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillOval(0, 0, PREF_W, PREF_W);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrollEg mainPanel = new ScrollEg();
            JFrame frame = new JFrame("ScrollEg");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}