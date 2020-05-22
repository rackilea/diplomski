import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Troy
 */
public class HelloWorld {
    public static void main(String[] args) {
        // I chose an ArrayList because the size does not have to be predetermined.
        List<String> toDo = new ArrayList<String>();
        System.out.println("What would you like to add to your to-do list?");
        Scanner userInput = new Scanner(System.in);

        // While the userInput still has entries, perform the following:
        while (userInput.hasNextLine()) {
            // Get the next line entered by the user
            String input = userInput.nextLine();

            //If input is "remove", remove the last item in the toDo list. (ArrayList)
            if ("remove".equals(input)) {
                if (toDo.size() > 0) {
                    toDo.remove(toDo.size() -1);
                }
            }
            /*
             * If the user types in "exit", when prompted for the next item in their
             * toDo list, close userInput, and print out... 
             */
            else if ("exit".equals(input)) {
                userInput.close();
                System.out.println("Your to-do list is complete!");
                System.out.println("Here is today's to-do list: ");

                final int perLine = 3;
                int i = 0;
                while(i < toDo.size()) {
                    // Print from the start of our current chunk (i)
                    //  to the end (i+3), or to the size of the list if our last chunk is smaller than "perLine".
                    System.out.println(
                        toDo.subList(i, Math.min(toDo.size(), i+perLine))
                    );
                    i+=perLine;
                }

                break;
            }
            /*
             * If input is neither "remove" nor "exit", add input to the list
             */
            else {
                toDo.add(input);
            }
        }
    }
}