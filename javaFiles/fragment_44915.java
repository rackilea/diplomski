import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestTextField {

    public static void main(String[] args) {
        final JTextField field = new JTextField(15);
        InputMap imap = field.getInputMap(JComponent.WHEN_FOCUSED);
        imap.put(KeyStroke.getKeyStroke("SPACE"), "spaceAction");
        ActionMap amap = field.getActionMap();
        amap.put("spaceAction", new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Space Pressed: " + field.getText());
            }
        });
        JOptionPane.showMessageDialog(null, field);
    }
}