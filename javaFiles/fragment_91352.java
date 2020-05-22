import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class CustomerPanel extends JPanel
{
  private JTextField nameField = new JTextField(20);
  private JTextField contactNumberField = new JTextField(20);

  public CustomerPanel()
  {
    add(new JLabel("Name:"));
    add(nameField);
    add(new JLabel("Contact number:"));
    add(contactNumberField);
  }

  // Recommended approach
  public void setCustomer(String name, String contact)
  {
    nameField.setText(name);
    contactNumberField.setText(contact);
  }

  // Inferior approach. Hence commented out
  //public JTextField getNameField()
  //{
  //  return nameField;
  //}

  // Inferior approach. Hence commented out
  //public JTextField getContactNumberField()
  //{
  //  return contactNumberField;
  //}

  public static void main(String[] args)
  {
    // Recommended approach
    CustomerPanel customerPanel = new CustomerPanel();
    customerPanel.setCustomer("Kevin James", "72362282");

    // Inferior approach. Hence commented out
    //customerPanel.getNameField().setText("Kevin James");
    //customerPanel.getContactNumberField().setText("72362282");

    JFrame frame = new JFrame("Customers");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(customerPanel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}