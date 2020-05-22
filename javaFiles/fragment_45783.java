import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

/** @see http://stackoverflow.com/a/13944679/230513 */
public class ActionTest {

    private void display() {
        JFrame f = new JFrame("ActionTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JButton(new ButtonAction()));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class ButtonAction extends AbstractAction {

        public ButtonAction() {
            putValue(NAME, "Button");
            putValue(SHORT_DESCRIPTION, "Combine the two values");
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ActionTest().display();
            }
        });
    }
}