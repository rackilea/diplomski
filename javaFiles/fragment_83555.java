import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

        private PhysicsPane physicsPane;

        public TestPane() {
            physicsPane = new PhysicsPane();
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = gbc.REMAINDER;
            JButton b1 = new JButton("1");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    startFirst();
                }
            });
            this.add(b1, gbc);
            this.add(physicsPane, gbc);
        }

        protected void startFirst() {
            physicsPane.startFirst();
        }

    }

    public class PhysicsPane extends JPanel {

        private Timer timer;
        private double xPos, yPos;
        private int tick;

        public PhysicsPane() {
            setBackground(Color.BLUE);
        }

        protected void stopTimer() {
            if (timer == null) {
                return;
            }
            timer.stop();
            timer = null;
        }

        public void startFirst() {
            stopTimer();

            xPos = 300;
            yPos = 500;
            tick = 0;

            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tick >= 150) {
                        stopTimer();
                        return;
                    }

                    yPos = .1 * tick * tick - 15 * tick + 550;

                    tick++;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fillOval((int) xPos, (int) yPos, 30, 30);
            g2d.dispose();
        }
    }

}