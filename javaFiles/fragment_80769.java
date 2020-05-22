import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/**
 * @see https://stackoverflow.com/a/34830519/230513
 */
public class MenuTest {

    private static final int MASK
        = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);
        JMenuItem menuItem = new JMenuItem();
        AbstractAction copyAction = new DefaultEditorKit.CopyAction();
        copyAction.putValue(Action.ACCELERATOR_KEY,
            KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK));
        menuItem.setAction(copyAction);
        menuItem.setText("Copy");
        menu.add(menuItem);
        menuBar.add(menu);
        f.setJMenuBar(menuBar);
        f.add(new JTextField(10));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new MenuTest()::display);
    }
}