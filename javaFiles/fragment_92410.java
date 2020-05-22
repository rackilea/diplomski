import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
public class TestControlBackspace {
    public static void main(String[] args) {
        KeyStroke ks1 = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, InputEvent.SHIFT_DOWN_MASK);
        KeyStroke ks2 = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, InputEvent.CTRL_DOWN_MASK);
        KeyStroke ks3 = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0);
        System.out.println(ks1);
        System.out.println(ks2);
        System.out.println(ks3);
    }
}