import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                MainFrame f = new MainFrame();
            }
        });
    }
    public JFrame frame = new JFrame();
    public JPanel panel = new JPanel(new BorderLayout());
    private WavePane waver;

    public MainFrame() {
        waver = new WavePane();
        JButton button1 = new JButton("Shweet Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setBackground(Color.black);
        frame.add(button1, BorderLayout.SOUTH);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stuff();
            }
        });
        panel.add(waver);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void stuff() {
//        for (int i = 0; i < 1000; i++) {
//            panel.add(new paintComponent());
//            panel.setBackground(Color.black);
//            frame.repaint();
//            try {
//                Thread.sleep(80);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//        }
        waver.walk(!waver.isWaving());
    }

    public class WavePane extends JComponent {

        private int options;
        private Timer timer;

        public WavePane() {
            setOpaque(false);
            timer = new Timer(80, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("tick");
                    options++;
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void walk(boolean walk) {
            if (walk) {
                timer.start();
            } else {
                timer.stop();
            }
        }

        public boolean isWaving() {
            return timer.isRunning();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);

            int height = getHeight();

            if (options % 2 == 0) {
                g2.drawOval(50, 100, 50, 50);
                g2.drawOval(60, 110, 8, 8);
                g2.fillOval(60, 110, 8, 8);
                g2.drawOval(80, 110, 8, 8);
                g2.fillOval(80, 110, 8, 8);
                g2.drawArc(65, 130, 100, 0, 140, 30);
                g2.drawLine(75, 150, 75, 220);
                g2.drawLine(75, 180, 100, 160);
                g2.drawLine(75, 180, 65, 210);
                g2.drawLine(75, 220, 50, 260);
                g2.drawLine(75, 220, 100, 260);
            } else {
                g2.drawOval(50, 100, 50, 50);
                g2.drawOval(60, 110, 8, 8);
                g2.fillOval(60, 110, 8, 8);
                g2.drawOval(80, 110, 8, 8);
                g2.fillOval(80, 110, 8, 8);
                g2.drawArc(65, 130, 100, 0, 140, 30);
                g2.drawLine(75, 150, 75, 220);
                g2.drawLine(75, 180, 100, 180);
                g2.drawLine(75, 180, 65, 210);
                g2.drawLine(75, 220, 50, 260);
                g2.drawLine(75, 220, 100, 260);
            }
        }
    }
}