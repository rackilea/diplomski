import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScreen {

    public static void main(String[] args) {
        new TestScreen();
    }

    public TestScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Frame frame = new Frame("Testing");
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                Screen screen = new Screen();
                frame.add(screen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                screen.start();
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }

    public class Screen extends Canvas implements Runnable {

        private static final int MAX_FPS = 60;
        private static final int FPS_SAMPLE_SIZE = 6;

        private boolean[] keysPressed = new boolean[256];

        private ArrayList<Character> characters = new ArrayList<>();
        private ArrayList<Character> ai = new ArrayList<>();
        private Thread thread;
        private BufferedImage bg;

        private long prevTick = -1;
        private LinkedList<Long> frames = new LinkedList<>();
        private int averageFPS;
        private boolean running;

        public Screen() {
            try {
                bg = ImageIO.read(new File("GUI Images/success.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            addKeyListener(new KeyListener() {
                public void keyPressed(KeyEvent e) {
                    keysPressed[e.getKeyCode()] = true;
                }

                public void keyReleased(KeyEvent e) {
                    keysPressed[e.getKeyCode()] = false;
                }

                public void keyTyped(KeyEvent e) {
                }
            });
            addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }
            });
            addMouseMotionListener(new MouseMotionListener() {
                public void mouseDragged(MouseEvent e) {
                }

                public void mouseMoved(MouseEvent e) {
                }
            });
            addMouseWheelListener(new MouseWheelListener() {
                public void mouseWheelMoved(MouseWheelEvent e) {
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            int height = ((Toolkit.getDefaultToolkit().getScreenSize().height - 32) / 5 * 4);
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            return new Dimension(width, height);
        }

        public void run() {

            createBufferStrategy(3);
            BufferStrategy bs = null;

            while (running) {
                bs = getBufferStrategy();
                Graphics g = bs.getDrawGraphics();
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                FontMetrics fm = g.getFontMetrics();
                g.setColor(Color.RED);
                g.drawString(String.valueOf(averageFPS), 0, fm.getAscent());
                g.dispose();
                bs.show();
                tick();
            }
        }

        public synchronized void start() {
            running = true;
            thread = new Thread(this);
            thread.start();
        }

        public synchronized void stop() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void tick() {
//            if (keysPressed[KeyEvent.VK_W] && (slime.getY() > 0)) {
//                slime.setY(slime.getY() - 1);
//            }
//            if (keysPressed[KeyEvent.VK_S] && (slime.getY() < height)) {
//                slime.setY(slime.getY() + 1);
//            }
//            if (keysPressed[KeyEvent.VK_A] && (slime.getY() > 0)) {
//                slime.setX(slime.getX() - 1);
//            }
//            if (keysPressed[KeyEvent.VK_D] && (slime.getY() < width)) {
//                slime.setX(slime.getX() + 1);
//            }
//            //  System.out.println(slime.getX() + ", " + slime.getY());

            long pastTime = System.currentTimeMillis() - prevTick;
            prevTick = System.currentTimeMillis();

            if (frames.size() == FPS_SAMPLE_SIZE) {
                frames.remove();
            }
            frames.add(pastTime);

            // Calculate average FPS
            long sum = 0;
            for (long frame : frames) {
                sum += frame;
            }
            long averageFrame = sum / FPS_SAMPLE_SIZE;
            averageFPS = (int) (1000 / averageFrame);

            // Only if the time passed since the previous tick is less than one
            // second divided by the number of maximum FPS allowed do we delay
            // ourselves to give Time time to catch up to our rendering.
            if (pastTime < 1000.0 / MAX_FPS) {
                try {
                    Thread.sleep((1000 / MAX_FPS) - pastTime);
                    System.out.println(averageFPS);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        }
    }

}