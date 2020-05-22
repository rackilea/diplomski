import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WalkCycle {

    public static void main(String[] args) {
        new WalkCycle();
    }

    public WalkCycle() {
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

        private List<BufferedImage> walkCycle;

        private int frame;

        private Timer timer;

        public TestPane() {
            setBackground(Color.WHITE);
            walkCycle = new ArrayList<>(10);
            try {
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk01.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk02.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk03.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk04.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk05.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk06.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk07.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk08.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk09.png")));
                walkCycle.add(ImageIO.read(getClass().getResource("/Walk10.png")));

                Timer timer = new Timer(80, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame++;
                        if (frame >= walkCycle.size()) {
                            frame = 0;
                        }
                        System.out.println(frame);
                        repaint();
                    }
                });

                InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
                ActionMap am = getActionMap();
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right-down");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right-up");

                am.put("right-down", new TimerAction(timer, true));
                am.put("right-up", new TimerAction(timer, false));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics g2d = (Graphics2D) g.create();
            BufferedImage img = walkCycle.get(frame);
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g2d.drawImage(img, x, y, this);
            g2d.dispose();
        }

    }

    public class TimerAction extends AbstractAction {

        private Timer timer;
        private boolean start;

        public TimerAction(Timer timer, boolean start) {
            this.timer = timer;
            this.start = start;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (start && !timer.isRunning()) {
                System.out.println("Start");
                timer.start();
            } else if (!start && timer.isRunning()) {
                System.out.println("stop");
                timer.stop();
            }
        }

    }

}