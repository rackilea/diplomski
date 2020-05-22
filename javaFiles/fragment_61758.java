import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class ArrowTest extends JFrame {

    public static void main(final String[] args) {
        final ArrowTest at = new ArrowTest();
        at.setSize(100, 200);

        final JPanel jp = new JPanel();
        jp.setBackground(Color.BLUE);
        jp.setFocusable(true);
        at.getContentPane().add(jp);
        final JToolBar toolbar = new JToolBar();
        JButton comp = new JButton();
        toolbar.add(comp);
        at.add(toolbar);
        at.setVisible(true);
    }

    public ArrowTest() {
        super();
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.BLACK);
        this.setKeyBindings();
    }

    public void setKeyBindings() {
        for (final Direction direction : Direction.values()) {
            MyArrowBinding binding = new MyArrowBinding(direction.getText());
            getRootPane().registerKeyboardAction(binding, direction.getText(), direction.getKeyStroke(),
                    JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        }
    }

    enum Direction {
        UP("Up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)), DOWN("Down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)), LEFT("Left",
                KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)), RIGHT("Right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));

        Direction(final String text, final KeyStroke keyStroke) {
            this.text = text;
            this.keyStroke = keyStroke;
        }

        private String text;
        private KeyStroke keyStroke;

        public String getText() {
            return text;
        }

        public KeyStroke getKeyStroke() {
            return keyStroke;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private class MyArrowBinding extends AbstractAction {

        private static final long serialVersionUID = -6904517741228319299L;

        public MyArrowBinding(final String text) {
            super(text);
            putValue(ACTION_COMMAND_KEY, text);
        }

        @Override
        public void actionPerformed(final ActionEvent e) {
            final String actionCommand = e.getActionCommand();
            System.out.println("Key Binding: " + actionCommand);
        }
    }
}