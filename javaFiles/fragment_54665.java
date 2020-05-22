import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// A very simple GUI to illustrate a point
public class ResistorGui extends JPanel {
   private JButton findColorButton = new JButton("Find Colors");
   private JTextField valueInputField = new JTextField(2);
   private JTextField resultField = new JTextField(15);

   public ResistorGui() {
      // user shouldn't be able to edit result field
      resultField.setEditable(false);
      resultField.setFocusable(false);

      findColorButton.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            // all program logic is in here

            // get value String from valueInputField
            // translate to int
            // call utility method from ResistorColorsUtil class!
            // display result in resultField
         }
      });

      add(new JLabel("Value:"));
      add(valueInputField);
      add(findColorButton);
      add(new JLabel("Result:"));
      add(resultField);
   }


   // all main does is to display the GUI, that's it
   public static void main(String[] args) {
      ResistorGui mainPanel = new ResistorGui();

      JFrame frame = new JFrame("ResistorGui");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}