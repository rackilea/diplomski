import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyApplication {

    public static void main(String[] args) {
        new MyApplication();
    }

    public MyApplication() {
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

    public static class TestPane extends JPanel {

        private static final Dimension DESIRED_SIZE = new Dimension(600, 600);
        private int width = 80, height = 80;

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return DESIRED_SIZE;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int xCord = 0, yCord = 0;

            while ((yCord) < getHeight()) {
                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                g2d.setColor(Color.getHSBColor(red, green, blue));
                g2d.fillRect(xCord, yCord, width, height);
                if ((xCord + width) > getWidth()) {
                    xCord = 0;
                    yCord += 80;
                } else {
                    xCord += 80;
                }
            }
            g2d.dispose();
        }

    }

}