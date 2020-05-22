import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MigLayoutExample extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MigLayoutExample frame = new MigLayoutExample();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MigLayoutExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow 33][grow 66]", "[][]"));

        JLabel lblNewLabel = new JLabel("New label");
        contentPane.add(lblNewLabel, "cell 0 0");

        textField = new JTextField();
        contentPane.add(textField, "cell 1 0,growx");
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("New label");
        contentPane.add(lblNewLabel_1, "cell 0 1");

        textField_1 = new JTextField();
        contentPane.add(textField_1, "cell 1 1,growx");
        textField_1.setColumns(10);
    }

}