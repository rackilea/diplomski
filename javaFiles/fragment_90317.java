import javax.swing.*;

public class JOptionPaneWithInput {
   public static void main(String[] args) {
      JTextField xField = new JTextField(5);
      JTextField yField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Input1:"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("input2:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
               "Please Enter input 1 and 2 Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         System.out.println("1 value: " + xField.getText());
         System.out.println("2 value: " + yField.getText());
      }
   }
}