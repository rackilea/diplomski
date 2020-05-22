import javax.swing.*;

public class MP1 extends JFrame  {

    public static void main(String[] args) {
        String myFile="";

        if (args.length == 0 || args[0].isEmpty()) {//reads in input from file
            //select
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal!=JOptionPane.CANCEL_OPTION) {
                myFile = chooser.getSelectedFile().getPath();
            } else {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                System.exit(0);
            }
        } else {
            myFile = args[0];
        }
        JOptionPane.showMessageDialog(null, "You have selected "+myFile+". Go play!");
    }

}