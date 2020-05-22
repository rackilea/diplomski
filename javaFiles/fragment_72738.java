import java.util.Scanner;
import java.util.Vector;

public class Main
{

    public static void main(String[] args)
    {
        String prompt = "Please enter a string or type QUIT to finish";
        Scanner userInput = new Scanner(System.in);
        Vector<String> names = new Vector<String>();
        System.out.println(prompt);

        String input = null;
        while (userInput.hasNextLine())
        {
            input = userInput.nextLine();
            if (input.equals("QUIT"))
                break;

            names.add(input);
        }

        for (String s : names)
        {
            System.out.println("You typed: ");
            System.out.println(s);
        }
    }
}