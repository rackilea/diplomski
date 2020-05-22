import javax.swing.JOptionPane;

public class textclass {

public static void main(String[] args) {

    boolean rightanswer = false;
    while (!rightanswer) {
        String inputText = JOptionPane
                .showInputDialog("What is the magic word?");
        String outputText = null;
        if (inputText.equalsIgnoreCase("themagicword")) {
            outputText = "Well done!";
            rightanswer = true;
        }
        if (!(inputText.equalsIgnoreCase("themagicword"))) {
            outputText = "Wrong!";
        }

        JOptionPane.showMessageDialog(null, outputText);
    } //end of new while bit
  }

}