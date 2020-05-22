public class My {

List<String> Hey;

public static void main(String args[]) {
    Hey = new ArrayList<String>();
}

private void btnFortsattActionPerformed(java.awt.event.ActionEvent evt) {
    //The variable name of the text field is "txfCreate"

    String text = txfCreate.getText();
    Hey.add(text);  //The problem here is that Netbeans cannot find "Hey" symbol 
}