import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class LongDraw {
    private JFrame frame;
    private Drawing drawing;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LongDraw()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        drawing = new Drawing();

        JScrollPane scroll = new JScrollPane(drawing);

        frame.add(scroll);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class Drawing extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.drawLine(10, 100, 3000, 10);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(3000, 500);
        }
    }
}