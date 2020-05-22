import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

final public class Test {

    private int timeStep = 0;
    private final int ballYTravel = 100;
    private final int BALL_NUM = 24;

    public static void main(String... args) {
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
                frame.add(new DrawPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    class DrawPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        public DrawPanel() {
            new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timeStep++;
                    repaint();
                }
            }).start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        public double getY(int i, int t) {
            return 100 + ballYTravel / 2 * (Math.sin(t * (i / 200d + 0.08)));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int k = 0; k < BALL_NUM; k++) {
                g.fillRect(10 + 20 * k, (int) getY(k, timeStep), 6, 6);
            }

        }
    }
}