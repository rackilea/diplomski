import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
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
import javax.swing.border.LineBorder;

public class BattleShipGame {

    public static void main(String[] args) {
        new BattleShipGame();
    }

    public BattleShipGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new OceanPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class OceanPane extends JPanel {

        private BattleShip ship;

        public OceanPane() {
            setLayout(new GridBagLayout());
            ship = new BattleShip();
            add(ship);

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ship.move();
                    revalidate();
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public static class BattleShip extends JPanel {

        protected static final int MAX_TURN_RATE = 5;

        private BufferedImage ship;
        private float angle;
        private float angleDelta;

        public BattleShip() {
            setOpaque(false);
            try {
                ship = ImageIO.read(new File("BattleShip.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setFocusable(true);
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftTurn");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightTurn");

            am.put("leftTurn", new TurnAction(-0.1f));
            am.put("rightTurn", new TurnAction(0.1f));
        }

        public void move() {

            angle += angleDelta;

        }

        public void setAngle(float angle) {
            this.angle = angle;
        }

        public float getAngle() {
            return angle;
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = new Dimension(0, 0);
            if (ship != null) {
                double rads = Math.toRadians(getAngle());
                double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
                int w = ship.getWidth();
                int h = ship.getHeight();
                size.width = (int) Math.floor(w * cos + h * sin);
                size.height = (int) Math.floor(h * cos + w * sin);
            }
            return size;
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (ship != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                double rads = Math.toRadians(getAngle());
                double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
                int w = ship.getWidth();
                int h = ship.getHeight();
                int newWidth = (int) Math.floor(w * cos + h * sin);
                int newHeight = (int) Math.floor(h * cos + w * sin);

                AffineTransform at = new AffineTransform();
                at.translate((newWidth - w) / 2, (newHeight - h) / 2);
                at.rotate(Math.toRadians(getAngle()), w / 2, h / 2);

                g2d.drawImage(ship, at, this);
                g2d.dispose();
            }
        }

        protected class TurnAction extends AbstractAction {

            protected float delta;

            public TurnAction(float delta) {
                this.delta = delta;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                angleDelta += delta;
                if (angleDelta > MAX_TURN_RATE) {
                    angleDelta = MAX_TURN_RATE;
                } else if (angleDelta < (MAX_TURN_RATE * -1)) {
                    angleDelta = (MAX_TURN_RATE * -1);
                }
            }

        }
    }
}