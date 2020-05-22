import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JScrollBarUnitIncrement {

    public static void main(String[] args) {
        final JFrame f = new JFrame("");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2000, 1));
        for (int i = 0; i != 2000; i++) {
            JButton btn = new JButton("Button 2");
            panel.add(btn);
        }
        final JScrollPane sPane = new JScrollPane(panel);
        final int increment = 50;
        sPane.getVerticalScrollBar().setUnitIncrement(increment);
        KeyStroke kUp = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
        KeyStroke kDown = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
        sPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(kUp, "actionWhenKeyUp");
        sPane.getActionMap().put("actionWhenKeyUp", new AbstractAction("keyUpAction") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                final JScrollBar bar = sPane.getVerticalScrollBar();
                int currentValue = bar.getValue();
                bar.setValue(currentValue - increment);
            }
        });
        sPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(kDown, "actionWhenKeyDown");
        sPane.getActionMap().put("actionWhenKeyDown", new AbstractAction("keyDownAction") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                final JScrollBar bar = sPane.getVerticalScrollBar();
                int currentValue = bar.getValue();
                bar.setValue(currentValue + increment);
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(sPane);
        f.pack();
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                f.setVisible(true);
            }
        });
    }

    private JScrollBarUnitIncrement() {
    }
}