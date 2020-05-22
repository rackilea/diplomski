import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JDialogTest extends JDialog {
private static final long serialVersionUID = 1L;
private String text;
private JTextField textField;

public JDialogTest(JFrame owner, String text){
    super(owner,true);
    this.text = text;
    init();
}


private void init() {
    this.getContentPane().setLayout(new BorderLayout());
    JButton btnContinue = new JButton("Close me and continue");
    btnContinue.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialogTest.this.dispose(); 
        }
    });
    textField = new JTextField();
    this.getContentPane().add(new JLabel(text),BorderLayout.NORTH);
    this.getContentPane().add(textField,BorderLayout.CENTER);
    this.getContentPane().add(btnContinue,BorderLayout.SOUTH);
    this.pack();
}

public JTextField getTextField() {
    return textField;
}

public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setVisible(true);
    JDialogTest test = new JDialogTest(frame, "Hello");
    System.out.println("I open");
    test.setLocationRelativeTo(null);
    test.setVisible(true);
    System.out.println("Good you closed it value is " + test.getTextField().getText());
    frame.setVisible(false);

}

 }