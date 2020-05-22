import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JOptionPaneTest {

    public void createAndShowJOptionPane() {
        final JButton b1 = new JButton("Yes, please");
        b1.setName("yes_please");
        final JButton b2 = new JButton("No, thx");
        b2.setName("no_thx");
        final JButton b3 = new JButton("Leave me alone");
        b3.setName("leave_me_alone");
        Object[] options = new Object[]{b1, b2, b3};

        final JOptionPane optionPane = new JOptionPane("Message", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, options, options[2]);
        final JDialog dialog = optionPane.createDialog("Title");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(b1.getText());
                optionPane.setValue(0);
                dialog.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(b2.getText());
                optionPane.setValue(1);
                dialog.dispose();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(b3.getText());
                optionPane.setValue(2);
                dialog.dispose();
            }
        });
        dialog.setVisible(true);

        if ((Integer)optionPane.getValue() == 0) {
            System.out.println("Woohoo!");
        }
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPaneTest test = new JOptionPaneTest();
                test.createAndShowJOptionPane();
            }
        });
    }
}