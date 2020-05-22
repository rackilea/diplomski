import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestJCheckBox {

    private JFrame frame;
    private JCheckBox jcb;
    private JButton button;

    public TestJCheckBox() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        jcb = new JCheckBox("JCheckBox1");

        button = new JButton("Is JCheckBox selected?");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jcb.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "JCheckBox is selected");
                } else {
                    JOptionPane.showMessageDialog(frame, "JCheckBox is NOT selected");

                }
            }
        });

        frame.add(jcb, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestJCheckBox();
            }
        });
    }
}