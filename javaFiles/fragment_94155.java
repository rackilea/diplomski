public class Calculator extends JFrame{

         Notepad notepad;

         public Caluclator(Notepad np){
             this();
             notepad = np;
             //any other code you need in your constructor
         }

         ...

         private class Insert implements ActionListener
         {
           public void actionPerformed(ActionEvent e)
           {
              String answer = proposal.getText(); // from the JLabel
                if (answer.isEmpty()) JOptionPane.showMessageDialog(frame, "Enter two numbers and hit the desired operator, please");
                else{
                     notepad.myJTextPane.setText(answer);
                }
            // ***
         }


}