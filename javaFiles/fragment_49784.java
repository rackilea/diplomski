import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class TheComboBoxes {
    public static void main(String[] args) {
        JOptionPane optionPane = new JOptionPane("The only way to close this dialog is by\n"
                + "pressing one of the following buttons.\n" + "Do you understand?", JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);
        JDialog dialog = optionPane.createDialog("click");
        dialog.setVisible(true);
    }
}