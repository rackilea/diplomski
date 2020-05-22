import javax.swing.JOptionPane;

public class CountVowels
{
    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog("Please enter a sentence, and I will count the vowels.");
        String[] letters = input.split("(?<=.)(?=.)");

        int count = 0;

        for(int i = 0; i < letters.length; i++)
        {
            if(letters[i].matches("[aeiou]"))
            {
                count++;
            }
        }
        System.out.println("There are " + count + " vowels in the string + " + input);
    }
}