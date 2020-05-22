import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RandomApplet extends JApplet {

    private RandomPane randomPane;
    private Timer timer;

    public RandomApplet() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new BorderLayout());
                randomPane = new RandomPane();
                add(randomPane);
            }
        });
    }

    @Override
    public void start() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Just want to make sure that the timer is not started before the
                // UI is initalised...
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                timer = new Timer(500, new ActionListener() {
                    private boolean state = false;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (state) {
                            randomPane.setForeground(Color.BLACK);
                        } else {
                            randomPane.randomise();
                            randomPane.setForeground(Color.WHITE);
                        }
                        state = !state;
                        repaint();
                    }
                });
                timer.start();
            }
        });
    }

    @Override
    public void stop() {
        timer.stop();
    }

    public class RandomPane extends JPanel {

        private int xPos;
        private int yPos;

        public RandomPane() {
            setBackground(Color.BLACK);
            setForeground(Color.BLACK);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(495, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
      g2d.setColor(getForeground());
      g2d.fillOval(xPos, yPos, 5, 5);
            g2d.dispose();
        }

        public void randomise() {
            xPos = (int) (Math.random() * (getWidth() - 5));
            yPos = (int) (Math.random() * (getHeight() - 5));
        }
    }
}