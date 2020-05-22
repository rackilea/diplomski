import javax.swing.*;
import java.awt.event.*;

class CustomActionListener implements ActionListener
{
  private JComboBox<String> comboBox;
  private JTextField textField;
  public CustomActionListener(JComboBox<String> comboBox, JTextField textField){
    this.comboBox = comboBox;
    this.textField = textField;
  }
  @Override
  public void actionPerformed(ActionEvent event)
  {
    // Just use the comboBox
    ComboBoxModel<String> model = comboBox.getModel();
    int index = comboBox.getSelectedIndex();
    String selectedAge = model.getElementAt(index);
                if(selectedAge.equals("10-17")) {
                    textField.setText("Not Eligible");
                } else {
                    textField.setText("Eligible");
                }
  }
}