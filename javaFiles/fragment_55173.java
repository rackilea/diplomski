import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                Main main = new Main();
                frame.add(main);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                main.start();
            }
        });
    }

    // Decouple the input from the implementation
    enum Input {
        UP, DOWN, LEFT, RIGHT
    }

    public class Main extends JPanel {

        boolean initilized = false;

        double FOV = 0.5 * Math.PI;

        private Instant lastFpsCheck = Instant.now();
        private Point mousePosition;
        private Timer timer;

        private Set<Input> input = new HashSet<>();

        public Main() {
            MouseAdapter mouseHandler = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    // This is within the components coordinate space
                    mousePosition = e.getPoint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mousePosition = e.getPoint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mousePosition = null;
                }
            };

            addMouseMotionListener(mouseHandler);
            addMouseListener(mouseHandler);

            InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "Pressed.up");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "Released.up");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "Pressed.down");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "Released.down");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "Pressed.left");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "Released.left");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "Pressed.right");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "Released.right");

            actionMap.put("Pressed.up", new InputAction(input, Input.UP, true));
            actionMap.put("Released.up", new InputAction(input, Input.UP, false));
            actionMap.put("Pressed.down", new InputAction(input, Input.DOWN, true));
            actionMap.put("Released.down", new InputAction(input, Input.DOWN, false));
            actionMap.put("Pressed.left", new InputAction(input, Input.LEFT, true));
            actionMap.put("Released.left", new InputAction(input, Input.LEFT, false));
            actionMap.put("Pressed.right", new InputAction(input, Input.RIGHT, true));
            actionMap.put("Released.right", new InputAction(input, Input.RIGHT, false));

            timer = new Timer(15, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    update();
                }
            });
        }

        public void start() {
            startTime = Instant.now();
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        // The start time of a given cycle
        private Instant startTime;
        // The estimated number of frames per second
        private double fps = 0;
        // The number of acutal updates performed
        // within a given cycle
        private int updates = 0;

        protected void update() {

            if (startTime == null) {
                startTime = Instant.now();
            }

            if (input.contains(Input.UP)) {
                //cam.update(delta_time, "W");
            }
            if (input.contains(Input.LEFT)) {
                //cam.update(delta_time, "A");
            }
            if (input.contains(Input.DOWN)) {
                //cam.update(delta_time, "S");
            }
            if (input.contains(Input.RIGHT)) {
                //cam.update(delta_time, "D");
            }
            // Don't know what these do, so you will need to devices
            // your own action
            //if (input.contains(Input.UP)) {
            //cam.update(delta_time, "E");
            //}
            //if (input.contains(Input.UP)) {
            //cam.update(delta_time, "Q");
            //}

            Instant endTime = Instant.now();
            Duration deltaTime = Duration.between(startTime, endTime);
            if (lastFpsCheck.plusSeconds(1).isBefore(endTime)) {
                System.out.println(deltaTime.toMillis());
                lastFpsCheck = endTime;
                fps = updates;
                updates = 0;
                startTime = Instant.now();
            }

            updates++;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        double[] rotate2D(double[] pos, double[] rot) {
            double x = pos[0];
            double y = pos[1];

            double s = rot[0];
            double c = rot[1];

            double[] result = {(x * c) - (y * s), (y * c) + (x * s)};

            return result;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Point startMousePos = MouseInfo.getPointerInfo().getLocation();
            //double startMouseX = startMousePos.getX();
            //double startMouseY = startMousePos.getY();

            Graphics2D g2d = (Graphics2D) g.create();

            // Drawing Debugger Menu
            g2d.drawString("HI WASSUp", 0, 20);

            if (mousePosition != null) {
                g2d.drawString(mousePosition.x + "x" + mousePosition.y, 0, 40);
                // Your old code is broken, because MouseInfo.getPointerInfo 
                // doesn't give you the position of the mouse from within
                // the components coordinate space, but in the screen space
                // instead
                //robot.mouseMove(cx, cy);
                //Point endMousePos = MouseInfo.getPointerInfo().getLocation();
                //double endMouseX = endMousePos.getX();
                //double endMouseY = endMousePos.getY();
                //double[] rel = {startMouseX - endMouseX, startMouseY - endMouseY};
                //cam.mouseMotion(rel);
            }

            g2d.drawString(Double.toString(fps), 0, 60);

            StringJoiner sj = new StringJoiner(", ");
            for (Input item : input) {
                switch (item) {
                    case DOWN:
                        sj.add("down");
                        break;
                    case UP:
                        sj.add("up");
                        break;
                    case LEFT:
                        sj.add("left");
                        break;
                    case RIGHT:
                        sj.add("right");
                        break;
                }
            }

            g2d.drawString(sj.toString(), 0, 80);
            g2d.dispose();
        }

        public class InputAction extends AbstractAction {

            private final Set<Input> input;
            private final Input direction;
            private final boolean add;

            public InputAction(Set<Input> input, Input direction, boolean add) {
                this.input = input;
                this.direction = direction;
                this.add = add;
            }

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (add) {
                    input.add(direction);
                } else {
                    input.remove(direction);
                }
            }

        }

    }
}