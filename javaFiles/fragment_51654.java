import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameTest {

    private JPanel panel;
    private JLabel lblLabel;
    private JFrame frame;

    private void initComponents() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));

        lblLabel = new JLabel("LABEL");
        panel.add(lblLabel, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("Press");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test t = new Test();
                t.buttonPress();
            }
        });

        panel.add(btnNewButton, BorderLayout.WEST);

        frame.add(panel);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public void writeLabel(String k) {
        this.lblLabel.setText(k);
    }

    void mainScreen() {
        initComponents();
    }
}