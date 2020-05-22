import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author shane
 */
public class Test {

    /**
     * @param args the command line arguments
     */
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
            setLayout(new GridLayout(3, 3));
            add(createButton("1", KeyEvent.VK_NUMPAD1));
            add(createButton("2", KeyEvent.VK_NUMPAD2));
            add(createButton("3", KeyEvent.VK_NUMPAD3));
            add(createButton("4", KeyEvent.VK_NUMPAD4));
            add(createButton("5", KeyEvent.VK_NUMPAD5));
            add(createButton("6", KeyEvent.VK_NUMPAD6));
            add(createButton("7", KeyEvent.VK_NUMPAD7));
            add(createButton("8", KeyEvent.VK_NUMPAD8));
            add(createButton("9", KeyEvent.VK_NUMPAD9));
        }

        protected JButton createButton(String name, int virtualKey) {
            JButton btn = new JButton(name);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand() + " was clicked");
                }
            });
            btn.setMargin(new Insets(8, 8, 8, 8));
            InputMap im = btn.getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = btn.getActionMap();
            im.put(KeyStroke.getKeyStroke(virtualKey, 0), "clickMe");
            am.put("clickMe", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    btn.doClick();
                }
            });
            return btn;
        }

    }

}