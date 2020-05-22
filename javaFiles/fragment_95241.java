import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Example extends JFrame {
    public Example() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setBounds(0, 0,250,200);
        // setLayout(null);

        JPanel panel = new JPanel();
        int gap = 40;
        panel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));

        JTextField jTextField1 = new JTextField(20);
        jTextField1.setEditable(false);
        panel.add(jTextField1);

        // get input and action maps to do key binding
        InputMap inputMap = jTextField1.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = jTextField1.getActionMap();

        // the key stroke that we want to change bindings on: delete key
        KeyStroke delKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);

        // tell the input map to map the key stroke to a String of our choosing
        inputMap.put(delKeyStroke, delKeyStroke.toString());

        // map this same key String to an action that does **nothing**
        actionMap.put(delKeyStroke.toString(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // do nothing
            }
        });

        add(panel);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Example example = new Example();
            example.pack();
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        });
    }
}