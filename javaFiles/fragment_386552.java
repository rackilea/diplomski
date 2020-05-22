import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class JComboFun {
   public static void main(String[] args) {
      String[] weekdays = { "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday" };
      final JComboBox<String> combo = new JComboBox<>(weekdays);

      String[] options = { "OK", "Cancel", "Fugedaboutit" };

      String title = "Title";
      int selection = JOptionPane.showOptionDialog(null, combo, title,
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            options, options[0]);

      if (selection > 0) {
         System.out.println("selection is: " + options[selection]);
      }

      Object weekday = combo.getSelectedItem();
      if (weekday != null) {
         System.out.println("weekday: " + weekday);
      }

   }
}