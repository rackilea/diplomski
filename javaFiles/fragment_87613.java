import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.KeyEvent;
import javax.swing.FocusManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private int count = 0;
    private int xPos = 10;
    private int yPos = 10;

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                installKeyboardMonitor();
                for (int index = 0; index < 10; index++) {
                    makeWindow();
                }
            }
        });
    }

    public static void installKeyboardMonitor() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                if (ke.getID() == KeyEvent.KEY_PRESSED) {
                    System.out.println("Pressed");
                    if (ke.getKeyCode() == KeyEvent.VK_W) {
                        System.out.println("W Key");
                        if (ke.isControlDown()) {
                            System.out.println("Control down");
                            Window window = FocusManager.getCurrentManager().getActiveWindow();
                            if (window != null) {
                                window.dispose();
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        });
    }

    public void makeWindow() {
        count++;
        JFrame frame = new JFrame("Test " + count);
        frame.setContentPane(new JPanel(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        });
        frame.add(new JLabel("Window " + count));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocation(xPos, yPos);
        frame.setVisible(true);
        xPos += 100;
        yPos += 100;
    }

}