import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class Example {

    public Example() {

        JLabel label = new JLabel("0");
        ShortCutButton button = new ShortCutButton("1", KeyStroke.getKeyStroke(KeyEvent.VK_1, 0));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(Integer.parseInt(label.getText()) + 1));
            }
        });
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    public class ShortCutButton extends JButton {
        public ShortCutButton(String text, KeyStroke keyStroke) {
            setText(text);
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "42");
            getActionMap().put("42", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    doClick();
                }
            });
        }
    }

}