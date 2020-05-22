import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

class DistanceExample implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DistanceExample());
    }

    @Override
    public void run() {
        JLabel distanceLabel = new JLabel("--");
        MousePanel clickPanel = new MousePanel();

        Listener listener =
            new Listener(distanceLabel, clickPanel);
        clickPanel.addMouseListener(listener);
        clickPanel.addMouseMotionListener(listener);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);
        content.add(distanceLabel, BorderLayout.NORTH);
        content.add(clickPanel, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setContentPane(content);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class MousePanel extends JPanel {
        Point2D.Float mousePos;

        MousePanel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (mousePos != null) {
                g.setColor(Color.red);
                Point2D.Float center = centerOf(this);
                g.drawLine(Math.round(center.x),
                           Math.round(center.y),
                           Math.round(mousePos.x),
                           Math.round(mousePos.y));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    }

    static class Listener extends MouseAdapter {
        JLabel distanceLabel;
        MousePanel mousePanel;

        Listener(JLabel distanceLabel, MousePanel mousePanel) {
            this.distanceLabel = distanceLabel;
            this.mousePanel = mousePanel;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            Point2D.Float mousePos =
                new Point2D.Float(e.getX(), e.getY());

            mousePanel.mousePos = mousePos;
            mousePanel.repaint();

            double dist = distance(mousePos, mousePanel);

            distanceLabel.setText(String.format("%.2f", dist));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mousePanel.mousePos = null;
            mousePanel.repaint();

            distanceLabel.setText("--");
        }
    }

    static Point2D.Float centerOf(JComponent comp) {
        Point2D.Float center =
            new Point2D.Float((comp.getWidth() / 2f),
                              (comp.getHeight() / 2f));
        return center;
    }

    static double distance(Point2D p, JComponent comp) {
        return centerOf(comp).distance(p);
    }
}