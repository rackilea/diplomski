import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleSimon {

    public static void main(String[] args) {
        new SimpleSimon();
    }

    public SimpleSimon() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel board;
        private Timer timer;
        private int flashCount;
        private int flashTimes;

        private int flashColor;
        private Image[] colors;

        private Image original;

        private AnimationCallBack callBack;

        public TestPane() {

            colors = new Image[4];
            try {
                colors[0] = createImage(Color.BLUE);
                colors[1] = createImage(Color.GREEN);
                colors[2] = createImage(Color.RED);
                colors[3] = createImage(Color.YELLOW);
                original = createImage(Color.WHITE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            setLayout(new BorderLayout());
            board = new JLabel();
            board.setHorizontalAlignment(JLabel.CENTER);
            board.setVerticalAlignment(JLabel.CENTER);
            add(board);

            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flashCount < flashTimes) {
                        if (flashCount % 2 == 0) {
                            board.setIcon(new ImageIcon(colors[flashColor]));
                        } else {
                            board.setIcon(new ImageIcon(original));
                        }
                    } else {
                        board.setIcon(new ImageIcon(original));
                        timer.stop();
                        // Animation has stopped, make call back...
                        if (callBack != null) {
                            callBack.animationDone();
                        }
                    }
                    flashCount++;
                }
            });
            timer.setRepeats(true);

            JPanel buttons = new JPanel(new GridLayout(0, 2));

            final JButton btnOne = new JButton("#1");
            buttons.add(btnOne);
            btnOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flashCount = 0;
                    flashTimes = 1;
                    flashColor = (int) Math.round(Math.random() * 3);
                    timer.restart();

                    btnOne.setEnabled(false);
                    // Set the call back so we know when the
                    // animation has stopped...
                    callBack = new AnimationCallBack() {
                        @Override
                        public void animationDone() {
                            btnOne.setEnabled(true);
                        }
                    };
                }
            });

            final JButton btnTwo = new JButton("#2");
            buttons.add(btnTwo);
            btnTwo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flashCount = 0;
                    flashTimes = 3;
                    flashColor = (int) Math.round(Math.random() * 3);
                    timer.restart();
                    btnTwo.setEnabled(false);
                    // Set the call back so we know when the
                    // animation has stopped...
                    callBack = new AnimationCallBack() {
                        @Override
                        public void animationDone() {
                            btnTwo.setEnabled(true);
                        }
                    };
                }
            });
            add(buttons, BorderLayout.SOUTH);
        }

        protected Image createImage(Color color) {

            BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(color);
            g2d.fillRect(0, 0, 400, 400);

            return img;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public interface AnimationCallBack {
        public void animationDone();
    }
}