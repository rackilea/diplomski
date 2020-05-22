import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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
                for (int index = 0; index < 10; index++) {
                    makeWindow();
                }
            }
        });
    }

    public static void installKeyBindings(JComponent component) {
        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK), "Window.close");
        actionMap.put("Window.close", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.windowForComponent(component);
                if (window != null) {
                    window.dispose();
                }
            }
        });
    }

    public void makeWindow() {
        count++;
        JFrame frame = new JFrame("Test " + count);
        installKeyBindings(frame.getRootPane());
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