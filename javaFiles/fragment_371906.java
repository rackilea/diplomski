// should be named TicGame to comply with Java naming standards
public class ticgame extends JFrame {

   public ticgame() {

      // ....

      // here you re-declare the button1 variable
      // by doing this, you initialize the local variable that
      // is present int he constructor but leave the class field null
      JButton button1 = new JButton("");

      //....
   }

   public JButton button1;  // this guy remains null
   // .....
}