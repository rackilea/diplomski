import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
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

        private int flashColor;
        private Image[] colors;

        private Image original;

        public TestPane() {

            colors = new Image[4];
            try {
                colors[0] = ImageIO.read(getClass().getResource("/resources/Blue.PNG"));
                colors[1] = ImageIO.read(getClass().getResource("/resources/Green.PNG"));
                colors[2] = ImageIO.read(getClass().getResource("/resources/Red.PNG"));
                colors[3] = ImageIO.read(getClass().getResource("/resources/Yellow.PNG"));
                original = ImageIO.read(getClass().getResource("/resources/Original.PNG"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            setLayout(new BorderLayout());
            JButton btn = new JButton("Play");
            board = new JLabel();
            board.setHorizontalAlignment(JLabel.CENTER);
            board.setVerticalAlignment(JLabel.CENTER);
            add(board);

            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flashCount == 0) {
                        board.setIcon(new ImageIcon(colors[flashColor]));
                    } else {
                        board.setIcon(new ImageIcon(original));
                        timer.stop();
                    }
                    flashCount++;
                }
            });
            timer.setRepeats(true);

            add(btn, BorderLayout.SOUTH);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flashCount = 0;
                    flashColor = (int)Math.round(Math.random() * 3);
                    timer.restart();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(650, 400);
        }
    }
}