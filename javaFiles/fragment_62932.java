import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class TestNimbusTextField {

    private void initUI() {
        JFrame frame = new JFrame(TestNimbusTextField.class.getSimpleName());
        frame.setLayout(new FlowLayout());
        JTextField textfield = new JTextField(20);
        textfield.setText("good morning. Look like I have no problems with 'g' and 'p'.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textfield);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for (LookAndFeelInfo lafInfo : installedLookAndFeels) {
            if (lafInfo.getName().equals("Nimbus")) {
                UIManager.setLookAndFeel(lafInfo.getClassName());
                break;
            }
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestNimbusTextField().initUI();
            }
        });
    }

}