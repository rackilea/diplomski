public class MyFrame extends JFrame implements ... {
    // keep track of a randomly generated value
    private int actual;  // part of the class, not within a method
                         // each instance of the class will have its own value
                        // the variable exists as long as the instance exists

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Random rand = new Random();   // this could also be an instance variable instead of creating a  new one each time
        // int getal = rand.nextInt(100)+1;  getal would be a local method variable and is lost when the method returns
        actual = rand.nextInt(100)+1; // keep track of the random value
   }                                        

    private void guessBtnActionPerformed(java.awt.event.ActionEvent evt) {
        ...
        int guess = ...  // whatever the user guessed
        if (guess == actual) {
           ...
        } else if (guess > actual) {
           ...
        } else {
           ...
        }
    }

}