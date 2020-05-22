import javax.swing.JOptionPane;

public class Assignment1
{
    public static void main(String args[])
    {
        String input = JOptionPane.showInputDialog("Enter a string");
        if (istPalindrome(input))
        {
            JOptionPane.showMessageDialog(null,input+"is a palindrome");
        }
        else{
            JOptionPane.showMessageDialog(null ,input +"is not a palindrome");
        }
    }

    public static boolean istPalindrome(String a)/*error is here*/
    {
        char[] charArray = a.toCharArray();
        int i1 = 0;
        int i2 = a.length() - 1;

        while (i2 > i1) {
            if (charArray[i1] != charArray[i2]) {
                return false;
            }

            ++i1;
            --i2;
        }
        return true;
    }
}