import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CounterTestDemo4 extends JFrame {
   private JButton jbtAdd = new JButton("+");
   private JButton jbtSub = new JButton("-");
   private JTextField jtfNumber1 = new JTextField(8);

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new CounterTestDemo4();
            frame.setTitle("Counter Test");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
         }
      });

   }

   public CounterTestDemo4() {
      JPanel panel = new JPanel();
      panel.add(new JLabel("Enter Number:"));
      panel.add(jtfNumber1);
      panel.add(new JLabel("Result:"));
      panel.add(jbtAdd);
      panel.add(jbtSub);
      add(panel);
      BtnListener listener = new BtnListener();
      jbtAdd.addActionListener(listener);
      jbtSub.addActionListener(listener);
   }

   class BtnListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int int1;
         try {
            int1 = Integer.parseInt(jtfNumber1.getText());
            if (e.getSource().equals(jbtAdd)) {
               int1++;
               jtfNumber1.setText(String.valueOf(int1));
            }

            else if (e.getSource().equals(jbtSub)) {
               int1--;
               jtfNumber1.setText(String.valueOf(int1));
            }
         } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(jtfNumber1,
                  "Please enter a number in the text field",
                  "Text Field Without Number", JOptionPane.ERROR_MESSAGE);
            jtfNumber1.selectAll();
            jtfNumber1.requestFocusInWindow();
         }
      }
   }
}