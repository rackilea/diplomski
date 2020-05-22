import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class StartGame {

    public static void main(String[] argv) throws Exception {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1210, 700);
        mainFrame.setLocation(new java.awt.Point(150, 30));
        mainFrame.setLayout(null);
        mainFrame.setFocusable(true);
        mainFrame.setFocusTraversalKeysEnabled(true);
        mainFrame.setIconImage(new ImageIcon("images\\sword.png").getImage());
        JLabel thing = new JLabel("X");
        //thing.setIcon(new ImageIcon("image\\1.gif"));
        thing.setBounds(300, 300, thing.getPreferredSize().width, thing.getPreferredSize().height);

        InputMap inputMap = thing.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = thing.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "move.up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "move.up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "move.down");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "move.down");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "move.left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "move.left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "move.right");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "move.right");

        actionMap.put("move.up", new ThingAction(thing, new Point(0, -1)));
        actionMap.put("move.down", new ThingAction(thing, new Point(0, 1)));
        actionMap.put("move.left", new ThingAction(thing, new Point(-1, 0)));
        actionMap.put("move.right", new ThingAction(thing, new Point(1, 0)));

        mainFrame.add(thing);
        mainFrame.setVisible(true);
    }

    public static class ThingAction extends AbstractAction {
        private JLabel thing;
        private Point delta;

        public ThingAction(JLabel thing, Point delta) {
            this.thing = thing;
            this.delta = delta;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            thing.setLocation(thing.getX() + delta.x, thing.getY() + delta.y);
        }
    }
}