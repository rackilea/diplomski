import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BouncyBall {

    public static void main(String[] args) {
        new BouncyBall();
    }

    public BouncyBall() {
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
                frame.add(new BallCourt());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BallCourt extends JPanel {

        private JLabel beachBall;
        private int delta = 4;

        public BallCourt() {
            setLayout(null);
            beachBall = new JLabel();
            try {
                beachBall.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/BeachBallOfDoom.png"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            beachBall.setBounds(0, 100 - 16, 32, 32);
            add(beachBall);

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int x = beachBall.getX() + delta;
                    if (x + beachBall.getWidth() > getWidth()) {
                        delta *= -1;
                        x = (getWidth() - beachBall.getWidth()) + delta;
                    } else if (x < 0) {
                        delta *= -1;
                        x = delta;
                    }

                    beachBall.setLocation(x, beachBall.getY());
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}