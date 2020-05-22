import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        public enum Direction {

            UP, DOWN, LEFT, RIGHT;
        }

        private JToggleButton[] buttons;
        private Set keys;

        private Timer timer;

        private JLabel direction;

        public TestPane() {
            keys = new HashSet();
            direction = new JLabel("Stopped");

            timer = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (keys.isEmpty()) {
                        ((Timer) e.getSource()).stop();
                        direction.setText("Stopped");
                    } else {
                        StringJoiner joiner = new StringJoiner("-");
                        if (keys.contains(Direction.UP)) {
                            joiner.add("North");
                        }
                        if (keys.contains(Direction.DOWN)) {
                            joiner.add("South");
                        } 
                        if (keys.contains(Direction.LEFT)) {
                            joiner.add("West");
                        } 
                        if (keys.contains(Direction.RIGHT)) {
                            joiner.add("East");
                        }
                        direction.setText(joiner.toString());
                    }
                }

            });

            Monitor monitor = new Monitor() {
                @Override
                public void pressed(Direction direction) {
                    keys.add(direction);
                    timer.restart();
                }

                @Override
                public void released(Direction direction) {
                    keys.remove(direction);
                }
            };

            MovementAction up = new MovementAction("Up", Direction.UP, monitor);
            MovementAction down = new MovementAction("Down", Direction.DOWN, monitor);
            MovementAction left = new MovementAction("Left", Direction.LEFT, monitor);
            MovementAction right = new MovementAction("Right", Direction.RIGHT, monitor);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            gbc.gridx = 1;

            buttons = new JToggleButton[4];
            buttons[0] = new JToggleButton(up);
            buttons[1] = new JToggleButton(down);
            buttons[2] = new JToggleButton(left);
            buttons[3] = new JToggleButton(right);

            add(buttons[0], gbc);
            gbc.gridy = 2;
            add(buttons[1], gbc);

            gbc.gridy = 1;
            gbc.gridx = 0;
            add(buttons[2], gbc);
            gbc.gridx++;
            add(direction, gbc);
            gbc.gridx++;
            add(buttons[3], gbc);

            addTriggerKeyBindingTo(buttons[0], KeyEvent.VK_UP, KeyEvent.VK_W, KeyEvent.VK_NUMPAD8);
            addTriggerKeyBindingTo(buttons[1], KeyEvent.VK_DOWN, KeyEvent.VK_S, KeyEvent.VK_NUMPAD2);
            addTriggerKeyBindingTo(buttons[2], KeyEvent.VK_LEFT, KeyEvent.VK_A, KeyEvent.VK_NUMPAD6);
            addTriggerKeyBindingTo(buttons[3], KeyEvent.VK_RIGHT, KeyEvent.VK_D, KeyEvent.VK_NUMPAD4);

        }

        protected void addTriggerKeyBindingTo(JToggleButton comp, int... virtualKeys) {
            InputMap im = comp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = comp.getActionMap();

            for (int key : virtualKeys) {
                im.put(KeyStroke.getKeyStroke(key, 0), "trigger");
            }
            am.put("trigger", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JToggleButton button = (JToggleButton) e.getSource();
                    button.doClick();
                }
            });
        }

        protected class MovementAction extends AbstractAction {

            private Direction direction;
            private Monitor monitor;

            public MovementAction(String name, Direction direction, Monitor monitor) {
                putValue(NAME, name);
                this.direction = direction;
                this.monitor = monitor;
                putValue(SELECTED_KEY, false);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = (boolean) getValue(SELECTED_KEY);
                if (selected) {
                    monitor.pressed(direction);
                } else {
                    monitor.released(direction);
                }
            }

        }

        public interface Monitor {

            public void pressed(Direction direction);

            public void released(Direction direction);

        }

    }

}