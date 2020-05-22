import java.awt.*;
import javax.swing.*;

public class Applet extends JApplet {

   private JButton button1;
   private JTextField textBox1;

   @Override
   public void init() {
      button1 = new JButton("Calculate");
      textBox1 = new JTextField("number");
      textBox1.setFont(new Font("Courier", Font.PLAIN, 12));
      JPanel myPanel = new JPanel(); // JPanel uses FlowLayout by default
      myPanel.add(new JLabel("Enter a number: "));
      myPanel.add(textBox1);
      myPanel.add(button1);
      myPanel.setBackground(Color.gray);

      getContentPane().add(myPanel, BorderLayout.CENTER);
   }

}