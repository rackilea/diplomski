import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class SomeGame {

    public SomeGame() {
        JFrame frame = new JFrame("Some Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel dp = new DrawPanel();
        frame.add(dp);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SomeGame();
            }
        });

    }
}

class DrawPanel extends JPanel {

    ArrayList lines = new ArrayList();
    Point2D.Double start;
    final Color BROWN = new Color(156, 93, 82);
    Slider thread;
    Rectangle cow = null;
    boolean drawGuy = false;

    public DrawPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                super.mouseReleased(me);
                Point2D.Double end = new Point2D.Double(me.getX(), me.getY());
                lines.add(new Line2D.Double(start, end));
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
                start = new Point2D.Double(me.getX(), me.getY());
            }
        });
        setKeyBindings();
    }

    private void setKeyBindings() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "P");
        getActionMap().put("P", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thread = new Slider(DrawPanel.this);
                thread.action(true);
                thread.start();
            }
        });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "q");
        getActionMap().put("Q", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thread.action(false);
                drawGuy = false;
                thread = null;
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //lets go 2D :)
        Graphics2D g2d = (Graphics2D) g;

        //turn on anti aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setColor(Color.black);

        for (int i = 0; i < lines.size(); i++) {
            Line2D.Double temp = (Line2D.Double) lines.get(i);
            int x1 = Integer.parseInt("" + Math.round(temp.getX1()));
            int x2 = Integer.parseInt("" + Math.round(temp.getX2()));
            int y1 = Integer.parseInt("" + Math.round(temp.getY1()));
            int y2 = Integer.parseInt("" + Math.round(temp.getY2()));

            g2d.drawLine(x1, y1, x2, y2);
        }

        if (drawGuy) {
            try {
                URL url = this.getClass().getResource("resources/img/world/char.png");
                Image image = Toolkit.getDefaultToolkit().getImage(url);
                g.drawImage(image, cow.x, cow.y, this);
            } catch (Exception exc) {
            }
        }
    }

    private class Slider extends Thread {

        double velocity, gravity;
        boolean go = false;
        private final DrawPanel dp;

        private Slider(DrawPanel dp) {
            this.dp = dp;
        }

        public void run() {
            if (go) {
                initGuy();
                velocity = 0;
                gravity = 1;
            }
            while (go) {
                try {
                    Line2D.Double lineTaken = null;
                    boolean onLine = false;
                    int firstOnLine = -1;
                    for (int i = lines.size() - 1; i >= 0; i--) {
                        Line2D.Double temp = (Line2D.Double) lines.get(i);
                        if (temp.intersects(cow.x, cow.y, 50, 50)) {
                            lineTaken = temp;
                            onLine = true;
                            if (firstOnLine != i) {
                                firstOnLine = i;
                                gravity = 0;
                            }
                            break;
                        }
                    }
                    if (onLine) {
                        double grav = (lineTaken.y2 - lineTaken.y1) / 50;
                        double vlct = (lineTaken.x2 - lineTaken.x1) / 100;
                        if (velocity < 5) {
                            velocity += vlct;
                        }
                        if (gravity < 2.5) {
                            gravity += grav;
                        }
                    } else {
                        gravity += .2;
                    }
                    cow.x += velocity;
                    cow.y += gravity;

                    Thread.sleep(75);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            dp.repaint();
                        }
                    });
                } catch (Exception e) {
                    break;
                }
            }
        }

        public void action(boolean b) {
            go = b;
        }

        public void initGuy() {
            Line2D.Double firstLine = (Line2D.Double) lines.get(0);
            int x = Integer.parseInt("" + Math.round(firstLine.x1));
            int y = Integer.parseInt("" + Math.round(firstLine.y1));
            cow = new Rectangle(x + 30, y - 20, 30, 30);
            drawGuy = true;
        }
    }
}