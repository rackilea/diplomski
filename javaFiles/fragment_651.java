import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestColoredPanel {

    private static class ColoredPanel extends JPanel {

        private Color color = Color.RED;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(getColor());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

    }

    protected void initUI() {
        final JFrame frame = new JFrame(TestColoredPanel.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ColoredPanel panel = new ColoredPanel();
        frame.add(panel);
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                panel.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestColoredPanel().initUI();
            }
        });
    }
}