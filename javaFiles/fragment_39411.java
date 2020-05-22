import javax.swing.*;

class Palindrome
{
    public static void main(String args[])
    {
        display();
    }

    /**
     * Returns a five-digit string
     */
    public static String retrieveInput()
    {
        String number = JOptionPane.showInputDialog("Enter A Five Digit Number:"); //get input
        while(number.length() != 5) //continue to get input while it is not five digits
        {
            JOptionPane.showMessageDialog(null, number + " Is Not A Five Digit Number",
                "ERROR", JOptionPane.ERROR_MESSAGE);        
            number = JOptionPane.showInputDialog("Enter A Five Digit Number:");
        }
        return number; //return the input
    }

    /**
     * Returns whether the given five digit string is a palindrome
     */
    public static boolean check(String number)
    {
        return (number.charAt(0) == number.charAt(4) && number.charAt(1) == number.charAt(3)); //checks to see if the first character equals the fifth character and the second character equals the fourth character
    }

    public static void display()
    {
        String number = retrieveInput(); //gets input

        if(check(number)) //if it is a palindrome
        {
            JOptionPane.showMessageDialog(null, number + " is a palindrome"); //say it is a palindrome
        }
        else
        {
            JOptionPane.showMessageDialog(null, number + " is not a palindrome"); //say it isn't a palindrome
        }
    }
}