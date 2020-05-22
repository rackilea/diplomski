import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LightCycles {

    public static void main(String[] args) {
        new LightCycles();
    }

    public LightCycles() {
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

    public static class TestPane extends JPanel {

        private int xVelocity;
        private int yVelocity;

        protected static final int PLAYER_SIZE = 4;
        protected static final int DELTA = 4;

        private Point player;
        private Point lastTurn;
        private Path2D playerPath;

        public TestPane() {
            setBackground(Color.BLACK);
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

            am.put("left", new VelocityAction(-DELTA, 0));
            am.put("right", new VelocityAction(DELTA, 0));
            am.put("up", new VelocityAction(0, -DELTA));
            am.put("down", new VelocityAction(0, DELTA));

            xVelocity = DELTA;

            player = new Point(0, 100);
            lastTurn = new Point(player);
            playerPath = new Path2D.Float();
            playerPath.moveTo(0, 100); // Start position...

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player.x += xVelocity;
                    if (player.x > getWidth()) {
                        playerPath.lineTo(getWidth(), player.y);
                        playerPath.moveTo(0, player.y);
                        player.x = 0;
                        lastTurn = new Point(player);
                    }
                    if (player.x + PLAYER_SIZE < 0) {
                        playerPath.lineTo(0, player.y);
                        playerPath.moveTo(getWidth() - 1, player.y);
                        player.x = getWidth() - 1;
                        lastTurn = new Point(player);
                    }
                    player.y += yVelocity;
                    if (player.y > getHeight()) {
                        playerPath.lineTo(player.x, getHeight());
                        playerPath.moveTo(player.x, 0);
                        player.y = 0;
                        lastTurn = new Point(player);
                    }
                    if (player.y + PLAYER_SIZE < 0) {
                        playerPath.lineTo(player.x, 0);
                        playerPath.moveTo(player.x, getHeight() - 1);
                        player.y = getHeight() - 1;
                        lastTurn = new Point(player);
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLUE);
            g2d.draw(playerPath);
            g2d.draw(new Line2D.Float(lastTurn, player));
            g2d.drawRect(player.x - (PLAYER_SIZE / 2), player.y - (PLAYER_SIZE / 2), PLAYER_SIZE, PLAYER_SIZE);
            g2d.dispose();
        }

        public class VelocityAction extends AbstractAction {

            private final int xDelta;
            private final int yDelta;

            public VelocityAction(int xDelta, int yDelta) {
                this.xDelta = xDelta;
                this.yDelta = yDelta;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                xVelocity = xDelta;
                yVelocity = yDelta;
                lastTurn = new Point(player);
                playerPath.lineTo(player.x, player.y);
            }

        }
    }
}