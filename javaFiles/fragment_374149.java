import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JInternalFrame2 extends JInternalFrame {

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public JInternalFrame2() {
        setTitle("JInternalFrame2");
        setBounds(0, 0, 1366, 768);
        setClosable(true);
        getContentPane().setLayout(
                new MigLayout("", "[][][][][][]", "[][][][][][]"));

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInternalFrame2.this.dispose();
            }
        });
        getContentPane().add(btnBack, "cell 5 5");
        MainClass.dontmoveframe();
    }

}