import javax.swing.JOptionPane;

public class ScratchPaper {
    public static void main(String[]args) {
        String userName;
        String nameAnswer;
        String rulesYes;
        String rulesNo;
        String yesNo;

        userName = JOptionPane.showInputDialog("Enter Your Name");
        nameAnswer = ("Hello " + userName + " Welcome to Tic-Tac-Toe, Click OK to Start");
        JOptionPane.showMessageDialog( null, nameAnswer );
        yesNo = JOptionPane.showInputDialog("Would you like the rules (Y/N)");


        if (yesNo.equalsIgnoreCase("y")) 
        {
            rulesYes = ("Yes? The Rules: X goes first, each player takes turns to put their symbol in one of nine boxes, you cannot put your symbol in a box which already contains a symbol, the first one to make a row of three wins");
            JOptionPane.showMessageDialog( null, rulesYes );
        }
        else {
            rulesNo = ("No? Well too bad, here are the rules, The Rules: X goes first, each player takes turns to put their symbol in one of nine boxes, you cannot put your symbol in a box which already contains a symbol, the first one to make a row of three wins");
            JOptionPane.showMessageDialog( null, rulesNo );
        }
    }
}