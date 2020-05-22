import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * @see http://stackoverflow.com/a/13412208/230513
 */
public class ComboKeyTest extends JPanel {

    public ComboKeyTest() {
        JComboBox cpmbo = new JComboBox();
        cpmbo.addItem("One");
        cpmbo.addItem("Two");
        cpmbo.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,
            KeyEvent.ALT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK),
            "spacePopup");

        this.add(cpmbo);
    }

    private void display() {
        JFrame f = new JFrame("NewJavaGUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ComboKeyTest().display();
            }
        });
    }
}