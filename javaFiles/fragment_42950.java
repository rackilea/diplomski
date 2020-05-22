import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SpinnerTest {
   public static void main(String[] args) {
      JSpinner spinner = new JSpinner(new SpinnerNumberModel(1000000000L, 500L,
            50000000000000L, 1000L));

      JOptionPane.showMessageDialog(null, spinner);
   }
}