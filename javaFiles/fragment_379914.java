import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class TestList {
   static JFormattedTextField price;
   static NumberFormat format;
   static NumberFormatter formatter;

   public static void main(String[] args) {
      setValues();
      JPanel panel = new JPanel();
      panel.add(new JLabel("price:"));
      panel.add(price);

      JOptionPane.showMessageDialog(null, panel);
   }

   private static void setValues(){
      format = NumberFormat.getCurrencyInstance(Locale.US);
//      format.setMinimumFractionDigits(2);
//      format.setMaximumFractionDigits(2);
      formatter = new NumberFormatter(format);
      formatter.setMinimum(0.0);
      formatter.setMaximum(10000000.0);
      formatter.setAllowsInvalid(false);

      // formatter.setOverwriteMode(true);
      price = new JFormattedTextField(formatter);
      price.setColumns(10);
      price.setValue(0.0);
  }
}