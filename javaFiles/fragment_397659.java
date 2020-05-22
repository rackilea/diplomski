import javax.swing.*;
import java.awt.*;
class RightAlignedTextField extends JTextField {
    public RightAlignedTextField(int columns) {
        super(columns);
        this.setHorizontalAlignment(RIGHT);
    }
}
public class Q21970358 extends JFrame {
    private final static long serialVersionUID = 0L;
    private JTextField t1 = new JTextField(30);
    private JTextField t2 = new JTextField(30);
    private JTextField t3 = new JTextField(30);
    private JTextField t4 = new JTextField(30);
    private JTextField t5 = new JTextField(30);
    private JTextField t6 = new RightAlignedTextField(30);
    public Q21970358() {
        super("Stack Overflow Q21970358");
        this.addTextFields();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 300));
    }
    public void alignAllRight(JTextField... fields) {
        for (JTextField t : fields) {
            t.setHorizontalAlignment(JTextField.RIGHT);
        }
    }
    public void addTextFields() {
        // Set all to align right
        // This is the part you're looking for
        // (2)
        this.alignAllRight(t1, t2, t3, t4, t5);
        JPanel panel = new JPanel();
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(t6); // (1)
        this.add(panel);
    }
    public static void main(String[] args) { new Q21970358(); }
}