public class ButtonAction extends AbstractAction 
  {
int i;
   public ButtonAction(String text, int i) {
    super(text);
    this.i = i;
    }
   public void actionPerformed(ActionEvent e) {
    /* you can put any action here. either make the action depend on array value or 
      the string text */
   System.out.println(i);

   }
 }