import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Rectangle box = new Rectangle(10, 10, 20, 20);

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            draw(g2d, Color.RED, Color.MAGENTA);
            g2d.dispose();

            g2d = (Graphics2D) g.create();
            g2d.scale(1, -1);
            g2d.translate(0, -getHeight());
            draw(g2d, Color.BLUE, Color.GREEN);
            g2d.dispose();
        }

        protected void draw(Graphics2D g2d, Color boxColor, Color lineColor) {

            g2d.setColor(boxColor);
            g2d.fill(box);
            g2d.setColor(lineColor);
            g2d.drawLine(0, 0, getWidth(), getHeight());

        }

    }

}