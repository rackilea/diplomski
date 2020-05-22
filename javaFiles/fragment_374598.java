import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.*;

public class TestCalculatorListener extends JPanel {
   private JFormattedTextField loanAmountField = new JFormattedTextField(
         NumberFormat.getCurrencyInstance());

   public TestCalculatorListener() {
      loanAmountField.setColumns(8);
      loanAmountField.setEditable(false);
      loanAmountField.setFocusable(false);
      add(loanAmountField);
      add(new JButton(new CalculateListener(loanAmountField)));
   }

   private static void createAndShowGui() {
      TestCalculatorListener mainPanel = new TestCalculatorListener();

      JFrame frame = new JFrame("TestCalculatorListener");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

   private class CalculateListener extends AbstractAction {
      private JFormattedTextField loanAmountField;

      public CalculateListener(JFormattedTextField loanAmountField) {
         super("Calculate");
         putValue(MNEMONIC_KEY, KeyEvent.VK_C);
         this.loanAmountField = loanAmountField;
      }

      public void actionPerformed(ActionEvent event) {
         loanAmountField.setValue(new Double(12.22));
      }

   }
}