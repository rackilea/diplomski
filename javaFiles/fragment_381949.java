import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JButton btn = new JButton("Button");

                AbstractAction aa = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Here");

                        btn.requestFocusInWindow();//request that the button has focus
                    }
                };

                //so button can be pressed using F1 and ENTER
                btn.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
                btn.getActionMap().put("Enter", aa);
                btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
                btn.getActionMap().put("F1", aa);

                btn.addActionListener(aa);//so button can be clicked

                JTextField tf = new JTextField("added to show ENTER wont work unless button in focus");

                frame.add(tf);
                frame.add(btn, BorderLayout.SOUTH);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}