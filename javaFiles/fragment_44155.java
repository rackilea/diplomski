import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Cube extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Cube());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    double p[][] = new double[9][4];

    int x = 1, y = 2, z = 3;

    public enum HorizontalRotation {
        LEFT,
        RIGHT,
        NONE
    }
    public enum VerticalRotation {
        UP,
        DOWN,
        NONE
    }

    private HorizontalRotation horizontalRotation = HorizontalRotation.NONE;
    private VerticalRotation verticalRotation = VerticalRotation.NONE;

//  boolean xRotUp = false;
//  boolean yRotRight = false;
//  boolean xRotDown = false;
//  boolean yRotLeft = false;

    double px, py, pz;

    double angle_x = 0.02;
    double angle_y = 0.0150;
    double angle_z = 0.010;

    public Cube() {
        init();
        addKeyBinding("Left", KeyEvent.VK_LEFT, HorizontalRotation.LEFT);
        addKeyBinding("Right", KeyEvent.VK_RIGHT, HorizontalRotation.RIGHT);
        addKeyBinding("Up", KeyEvent.VK_UP, VerticalRotation.UP);
        addKeyBinding("Down", KeyEvent.VK_DOWN, VerticalRotation.DOWN);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    protected void addKeyBinding(String name, int keyCode, HorizontalRotation rotation) {
        addKeyBinding(name + ".pressed", KeyStroke.getKeyStroke(keyCode, 0, false), new HorizontalRotationAction(rotation));
        addKeyBinding(name + ".released", KeyStroke.getKeyStroke(keyCode, 0, true), new HorizontalRotationAction(HorizontalRotation.NONE));
    }

    protected void addKeyBinding(String name, int keyCode, VerticalRotation rotation) {
        addKeyBinding(name + ".pressed", KeyStroke.getKeyStroke(keyCode, 0, false), new VerticalRotationAction(rotation));
        addKeyBinding(name + ".released", KeyStroke.getKeyStroke(keyCode, 0, true), new VerticalRotationAction(VerticalRotation.NONE));
    }

    protected void addKeyBinding(String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    public void rotate() {
        for (int i = 0; i < 9; i++) {
            px = p[i][x];
            py = p[i][y];
            pz = p[i][z];
            if (verticalRotation == VerticalRotation.UP) {
                p[i][y] = py * Math.cos(angle_x) - pz * Math.sin(angle_x);
                p[i][z] = py * Math.sin(angle_x) + pz * Math.cos(angle_x);

                py = p[i][y];
                pz = p[i][z];
            } else if (verticalRotation == VerticalRotation.DOWN) {
                p[i][y] = py * Math.cos(-angle_x) - pz * Math.sin(-angle_x);
                p[i][z] = py * Math.sin(-angle_x) + pz * Math.cos(-angle_x);

                py = p[i][y];
                pz = p[i][z];
            }

            if (horizontalRotation == HorizontalRotation.RIGHT) {
                p[i][x] = px * Math.cos(angle_y) + pz * Math.sin(angle_y);
                p[i][z] = -px * Math.sin(angle_y) + pz * Math.cos(angle_y);

                px = p[i][x];
            } else if (horizontalRotation == HorizontalRotation.LEFT) {
                p[i][x] = px * Math.cos(-angle_y) + pz * Math.sin(-angle_y);
                p[i][z] = -px * Math.sin(-angle_y) + pz * Math.cos(-angle_y);

                px = p[i][x];
            }
        }
        repaint();
    }

    public void init() {
        setBackground(new Color(0, 0, 0));

        p[1][x] = -100;
        p[1][y] = -100;
        p[1][z] = -100;
        p[2][x] = +100;
        p[2][y] = -100;
        p[2][z] = -100;
        p[3][x] = +100;
        p[3][y] = -100;
        p[3][z] = +100;
        p[4][x] = -100;
        p[4][y] = -100;
        p[4][z] = +100;
        p[5][x] = -100;
        p[5][y] = +100;
        p[5][z] = -100;
        p[6][x] = +100;
        p[6][y] = +100;
        p[6][z] = -100;
        p[7][x] = +100;
        p[7][y] = +100;
        p[7][z] = +100;
        p[8][x] = -100;
        p[8][y] = +100;
        p[8][z] = +100;

        /*       8 - - - - - 7
                     / |         / |
                    5 - - - - - 6  |
                    |  |        |  |
                    |  4 - - - -|- 3
                    | /         | /
                    1 - - - - - 2
         */
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gBuffer = (Graphics2D) g.create();

        gBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        gBuffer.setColor(Color.LIGHT_GRAY);
        gBuffer.drawLine((int) (p[4][x]) + 200, (int) (p[4][y]) + 200, (int) (p[6][x]) + 200, (int) (p[6][y]) + 200);
        gBuffer.drawLine((int) (p[2][x]) + 200, (int) (p[2][y]) + 200, (int) (p[8][x]) + 200, (int) (p[8][y]) + 200);
        gBuffer.drawLine((int) (p[1][x]) + 200, (int) (p[1][y]) + 200, (int) (p[7][x]) + 200, (int) (p[7][y]) + 200);
        gBuffer.drawLine((int) (p[5][x]) + 200, (int) (p[5][y]) + 200, (int) (p[3][x]) + 200, (int) (p[3][y]) + 200);

        gBuffer.setColor(Color.DARK_GRAY);
        gBuffer.fillPolygon(new int[]{
            (int) p[1][x] + 200,
            (int) p[2][x] + 200,
            (int) p[6][x] + 200,
            (int) p[5][x] + 200},
                new int[]{
                    (int) p[1][y] + 200,
                    (int) p[2][y] + 200,
                    (int) p[6][y] + 200,
                    (int) p[5][y] + 200
                }, 4);
        gBuffer.setColor(Color.CYAN);
        gBuffer.drawLine((int) (p[1][x]) + 200, (int) (p[1][y]) + 200, (int) (p[2][x]) + 200, (int) (p[2][y]) + 200);
        gBuffer.drawLine((int) (p[2][x]) + 200, (int) (p[2][y]) + 200, (int) (p[3][x]) + 200, (int) (p[3][y]) + 200);
        gBuffer.drawLine((int) (p[3][x]) + 200, (int) (p[3][y]) + 200, (int) (p[4][x]) + 200, (int) (p[4][y]) + 200);
        gBuffer.drawLine((int) (p[4][x]) + 200, (int) (p[4][y]) + 200, (int) (p[1][x]) + 200, (int) (p[1][y]) + 200);
        gBuffer.drawLine((int) (p[5][x]) + 200, (int) (p[5][y]) + 200, (int) (p[6][x]) + 200, (int) (p[6][y]) + 200);
        gBuffer.drawLine((int) (p[6][x]) + 200, (int) (p[6][y]) + 200, (int) (p[7][x]) + 200, (int) (p[7][y]) + 200);
        gBuffer.setColor(Color.RED);
        gBuffer.drawLine((int) (p[7][x]) + 200, (int) (p[7][y]) + 200, (int) (p[8][x]) + 200, (int) (p[8][y]) + 200);
        gBuffer.setColor(Color.CYAN);
        gBuffer.drawLine((int) (p[8][x]) + 200, (int) (p[8][y]) + 200, (int) (p[5][x]) + 200, (int) (p[5][y]) + 200);
        gBuffer.drawLine((int) (p[1][x]) + 200, (int) (p[1][y]) + 200, (int) (p[5][x]) + 200, (int) (p[5][y]) + 200);
        gBuffer.drawLine((int) (p[2][x]) + 200, (int) (p[2][y]) + 200, (int) (p[6][x]) + 200, (int) (p[6][y]) + 200);
        gBuffer.drawLine((int) (p[3][x]) + 200, (int) (p[3][y]) + 200, (int) (p[7][x]) + 200, (int) (p[7][y]) + 200);
        gBuffer.setColor(Color.BLUE);
        gBuffer.drawLine((int) (p[4][x]) + 200, (int) (p[4][y]) + 200, (int) (p[8][x]) + 200, (int) (p[8][y]) + 200);
        gBuffer.dispose();
    }

    protected class HorizontalRotationAction extends AbstractAction {

        private HorizontalRotation rotation;

        public HorizontalRotationAction(HorizontalRotation rotation) {
            this.rotation = rotation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            horizontalRotation = rotation;
            rotate();
        }

    }

    protected class VerticalRotationAction extends AbstractAction {

        private VerticalRotation rotation;

        public VerticalRotationAction(VerticalRotation rotation) {
            this.rotation = rotation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            verticalRotation = rotation;
            rotate();
        }

    }

}