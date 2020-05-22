import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridLayout(4, 3));
            add(createButton(7, KeyEvent.VK_7, KeyEvent.VK_NUMPAD7));
            add(createButton(8, KeyEvent.VK_8, KeyEvent.VK_NUMPAD8));
            add(createButton(9, KeyEvent.VK_9, KeyEvent.VK_NUMPAD9));
            add(createButton(4, KeyEvent.VK_4, KeyEvent.VK_NUMPAD4));
            add(createButton(5, KeyEvent.VK_5, KeyEvent.VK_NUMPAD5));
            add(createButton(6, KeyEvent.VK_6, KeyEvent.VK_NUMPAD6));
            add(createButton(1, KeyEvent.VK_1, KeyEvent.VK_NUMPAD1));
            add(createButton(2, KeyEvent.VK_2, KeyEvent.VK_NUMPAD2));
            add(createButton(3, KeyEvent.VK_3, KeyEvent.VK_NUMPAD3));
            add(createButton(0, KeyEvent.VK_0, KeyEvent.VK_NUMPAD0));
        }

        protected JButton createButton(int number, int... virtualKeys) {

            NumberAction na = new NumberAction(Integer.toString(number));
            JButton btn = new JButton(na);

            InputMap im = btn.getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            ActionMap am = btn.getActionMap();

            for (int virtualKey : virtualKeys) {

                im.put(KeyStroke.getKeyStroke(virtualKey, 0, false), "number-pressed");
                im.put(KeyStroke.getKeyStroke(virtualKey, 0, true), "number-released");

            }

            am.put("number-pressed", new NumberKeyPressedAction(btn, true));
            am.put("number-released", new NumberKeyPressedAction(btn, false));

            return btn;

        }

        public class NumberAction extends AbstractAction {

            public NumberAction(String name) {
                super(name);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getValue(NAME) + " was clicked");
            }

        }

        public class NumberKeyPressedAction extends AbstractAction {

            private final JButton btn;
            private final boolean pressed;

            public NumberKeyPressedAction(JButton btn, boolean pressed) {
                // You could just pass the button model, but this was easier...
                this.btn = btn;
                this.pressed = pressed;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (pressed) {
                    btn.getModel().setArmed(pressed);
                    btn.getModel().setPressed(pressed);
                } else {
                    btn.getModel().setPressed(pressed);
                    btn.getModel().setArmed(pressed);
                }
            }

        }

    }

}