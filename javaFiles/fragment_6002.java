import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Demo {    

    private void initGUI(){        

        final JTextField textField = new JTextField(20);
        final JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        

        JButton button = new JButton("Accept");        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("user".equals(textField.getText())){
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    // or simply frame.dispose()
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong user! Keep trying.", "Login failed", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JPanel login = new JPanel(new FlowLayout());
        login.add(new JLabel("User"));
        login.add(textField);
        login.add(button);

        frame.getContentPane().add(login);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    

    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }
}