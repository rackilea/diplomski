import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

public class DialogTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "spaceAction");
        frame.getRootPane().getActionMap().put("spaceAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EventQueue.getCurrentEvent() instanceof KeyEvent) {
                    KeyEvent ke = (KeyEvent) EventQueue.getCurrentEvent();
                    if (!(ke.getComponent() instanceof JTextComponent)) {
                        System.out.println("spaceAction");
                    } else {
                        System.out.println("Ignore event in text component");
                    }
                } else {
                    System.out.println("spaceAction");
                }
            }
        });
        JTextField tf = new JTextField("textfield");
        JLabel label = new JLabel("otherComponent");
        label.setFocusable(true);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(tf);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);

    }

}