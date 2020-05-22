import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** @see http://stackoverflow.com/a/11085850/230513 */
public class EnterTest extends JPanel {

    public EnterTest() {
        super(new GridLayout(0, 1));
        final JButton add = new JButton(new AbstractAction("Add") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add");
            }
        });
        JTextField addKeywordField = new JTextField("Press enter.");
        addKeywordField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add.doClick();
            }
        });
        this.add(addKeywordField);
        this.add(add);
    }

    private void display() {
        JFrame f = new JFrame("EnterTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EnterTest().display();
            }
        });
    }
}