import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextFieldAndActionListener implements ActionListener {

    private JFrame frm = new JFrame("JTextFieldAndActionListener");
    private JTextField one = new JTextField(10);
    private JTextField two = new JTextField();
    private JTextField three = new JTextField();

    public JTextFieldAndActionListener() {
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        frm.setLayout(new GridLayout());
        frm.add(one);
        frm.add(two);
        frm.add(three);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(400, 300);
        frm.pack();
        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == one) {
            System.out.println("firing from JTextField one");
        } else if (source == two) {
            System.out.println("firing from JTextField two");
        } else if (source == three) {
            System.out.println("firing from JTextField three");
        } else {
            System.out.println("something went wrong");
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTextFieldAndActionListener ie = new JTextFieldAndActionListener();
            }
        });
    }
}