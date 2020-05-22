import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ComboModelEg extends JPanel {
   private DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
   private JComboBox<String> comboBox = new JComboBox<>(comboModel);
   private JTextField textField = new JTextField(5);

   public ComboModelEg() {
      // so combo box is wide enough
      comboBox.setPrototypeDisplayValue("              ");
      add(comboBox);
      add(textField);
      add(new JButton(new AddToComboAction("Add Text", KeyEvent.VK_A)));
   }

   // AbstractAction is like a *super* ActionListener
   private class AddToComboAction extends AbstractAction {
      public AddToComboAction(String name, int mnemonic) {
         super(name);  // button's text
         putValue(MNEMONIC_KEY, mnemonic); // button's mnemonic key
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String text = textField.getText(); //get text from text field
         comboModel.addElement(text);  // and put it into combo box's model
      }
   }   

   private static void createAndShowGui() {
      ComboModelEg mainPanel = new ComboModelEg();

      JFrame frame = new JFrame("ComboModelEg");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}