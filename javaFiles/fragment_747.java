import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class PacManTest {

    public static void main(String[] args) {
        new PacManTest();
    }

    public PacManTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MazePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PacMan {

        private int x;
        private int y;

        private int deltaX;
        private int deltaY;

        private BufferedImage sprite;

        public PacMan() {
            try {
                sprite = ImageIO.read(new File("PacMan.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void move(int x, int y) {
            deltaX = x;
            deltaY = y;
        }

        public void update(MazePane pane) {
            x += deltaX;
            y += deltaY;
            if (x + sprite.getWidth() > pane.getWidth()) {
                x = pane.getWidth() - sprite.getWidth();
            } else if (x < 0) {
                x = 0;
            }
            if (y + sprite.getHeight() > pane.getHeight()) {
                y = pane.getHeight() - sprite.getHeight();
            } else if (y < 0) {
                y = 0;
            }
        }

        public void paint(MazePane pane, Graphics2D g2d) {
            Graphics2D g = (Graphics2D) g2d.create();

            float angle = 0;
            if (deltaX != 0) {
                angle = deltaX > 0 ? 0 : 180;
            } else if (deltaY != 0) {
                angle = deltaY > 0 ? 90 : 270;                
            }
            AffineTransform t = new AffineTransform();
            t.translate(x, y);
            t.rotate(Math.toRadians(angle), sprite.getWidth() / 2, sprite.getHeight() / 2);
            g.setTransform(t);
            g.drawImage(sprite, 0, 0, pane);
            g.dispose();
        }

    }

    public class MazePane extends JPanel {

        private PacMan pacMan;
        public MazePane() {
            pacMan = new PacMan();
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pacMan.update(MazePane.this);
                    repaint();
                }
            });
            timer.start();
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

            am.put("left", new MoveAction(pacMan, -4, 0));
            am.put("right", new MoveAction(pacMan, 4, 0));
            am.put("up", new MoveAction(pacMan, 0, -4));
            am.put("down", new MoveAction(pacMan, 0, 4));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            pacMan.paint(this, g2d);
            g2d.dispose();
        }

        public class MoveAction extends AbstractAction {

            private int deltaX;
            private int deltaY;
            private PacMan pacMan;

            public MoveAction(PacMan pacMan, int deltaX, int deltaY) {
                this.deltaX = deltaX;
                this.deltaY = deltaY;
                this.pacMan = pacMan;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                pacMan.move(deltaX, deltaY);
            }

        }        
    }
}