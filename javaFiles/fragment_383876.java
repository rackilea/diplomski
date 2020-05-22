import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BDialog extends JDialog {

    private JButton okBtn = new JButton("OK");
    private JButton cancelBtn = new JButton("Cancel");
    private JLabel messageLbl = new JLabel("This is a message");

    public BDialog() {
        super(new JFrame(), true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(messageLbl);
        add(okBtn);
        add(cancelBtn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BDialog();
    }

}