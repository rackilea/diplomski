import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;

/** @see https://stackoverflow.com/a/14429304/230513 */
public class JCButtonTest {

    private void display() {
        JFrame f = new JFrame("JCButtonTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JCButton(new AbstractAction("JCButton") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        }));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class JCButton extends AbstractButton {

        public static final int SIZE = 32;

        public JCButton(Action action) {
            this.setModel(new DefaultButtonModel());
            System.out.println(action.getValue(Action.NAME));
            this.init((String) action.getValue(Action.NAME), null);
            this.addActionListener(action);
        }

        @Override
        public void updateUI() {
            setUI((ButtonUI) UIManager.getUI(this));
        }

        @Override
        public String getUIClassID() {
            return "ButtonUI";
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JCButtonTest().display();
            }
        });
    }
}