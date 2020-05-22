import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QueueDialog extends JFrame implements ActionListener {
  private static final long SerialVersionUID = 1L;
  private static JTextField field = new JTextField(15);
  //private Sender sender;
  private String incommingMessagesFolderUrl = "/etc/dlp/templates";

  public QueueDialog() throws Exception {

   // sender = new Sender();

    // field.setSize(60, 15);
    JButton okButton = new JButton("ok");
    final JLabel label = new JLabel("Enter the name of queue:");
    GridBagLayout gbag = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    setLayout(gbag);

   // gbc.insets = new Insets(2, 0, 2, 0);
    gbc.gridy = 0;
    gbc.gridx = 0;
    gbag.setConstraints(label, gbc);
    gbc.gridy = 1;
    gbc.gridx = 0;
    gbag.setConstraints(field, gbc);
    gbc.gridy = 2;
    gbc.gridx = 0;
    gbag.setConstraints(okButton, gbc);

    add(okButton);
    add(field);
    add(label);
    setTitle("Queue name");
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(400, 200);
    setLocationRelativeTo(null);
    setVisible(true);

    okButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ok")) {
            System.out.println("Hello");
            setVisible(false);


          // label.setText(field.getText());
         // send(field.getText());
        }
      }
    });
  }

@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

}



public static void main(String[] args) throws Exception {
    QueueDialog diag = new QueueDialog();
}
}