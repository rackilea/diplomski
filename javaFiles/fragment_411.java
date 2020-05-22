import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Key extends JPanel {

    public void action() {
        JLabel label = new JLabel("Waiting");
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "press.a");
        actionMap.put("press.a", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Pressed A");
            }
        });
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "release.a");
        actionMap.put("release.a", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Waiting");
            }
        });

        add(label);
    }

    public static void main(String[] args) {
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
                JPanel panel = new JPanel();
                panel.setBackground(Color.BLUE);
                frame.add(panel);
                Key k = new Key();
                k.action();
                frame.add(k, BorderLayout.SOUTH);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}