import java.awt.event.*;
import javax.swing.*;

public class TestF1KeyBind {

    public TestF1KeyBind() {
        final JFrame frame = new JFrame("Frame");
        JPanel panel = new JPanel();

        InputMap im = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "openDialog");
        ActionMap am = panel.getActionMap();
        am.put("openDialog", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, true);
                dialog.setSize(300, 300);
                dialog.setTitle("Dialog");
                dialog.setLocationByPlatform(true);
                dialog.setVisible(true);
            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestF1KeyBind();
            }
        });
    }
}