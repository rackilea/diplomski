public class CharInput {

    public static void main(String... str) throws IOException {

        // open Scanner for input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input");
        //since you want only lowercase as input so converting at front is an better option
        String playerInput = keyboard.next().toLowerCase();

        // to make sure we have only char input nothing else
        char input = playerInput.charAt(0);

        // Check if the inputted char is between a and l only
        if (input >= 'a' && input <='l' ){

    // Do the stuff you want to do if the input is in between
    // with the char variable input
        }
        else{
            System.out.println("Error Raised");
        }

    }
}