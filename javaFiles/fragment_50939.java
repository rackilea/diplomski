import java.text.ParseException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Test {

      public static void main(String[] args) throws ParseException
      {

          JTextField textField = new JFormattedTextField();
          textField.setInputVerifier(new MyInputVerifier());
      }
}

class MyInputVerifier extends InputVerifier {

      public MyInputVerifier() {}

      @Override
    public boolean verify(JComponent input) {

        JTextField textField = (JTextField) input;
        String validate = textField.getText();
          if (validate !=null /* replace with relevant tests cosde */) {

              return true;
          } else {

              return false;
          }
      }
  }