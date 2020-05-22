import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class RandomShape extends JPanel {

    public static void main(String[] args) {
        new RandomShape();
    }

    public RandomShape() {
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

        private double randomX;
        private double randomY;
        private double randomW;
        private double randomH;

        public TestPane() {
                setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), new LineBorder(Color.BLACK)));
                Timer timer = new Timer(500, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    random();
                }
            });
            timer.start();
        }

        public void random() {

            randomW = 10 + (Math.random() * 40);
            randomH = 10 + (Math.random() * 40);

            Insets insets = getInsets();
            int width = getWidth() - (insets.left + insets.right);
            int height = getHeight() - (insets.top + insets.bottom);

            randomX = insets.left + (Math.random() * (width - randomW));
            randomY = insets.top + (Math.random() * (height - randomH));

            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Ellipse2D.Double circle = new Ellipse2D.Double(randomX,
                            randomY,
                            randomW,
                            randomH);
            g2d.fill(circle);
            g2d.dispose();
        }

    }

}