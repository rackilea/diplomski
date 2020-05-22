public class Hmwk03 {

public static void main(String[] args) {
    int number1 = (int)(Math.random() * 10);
    int number2 = (int)(Math.random() * 10);
    int counter = 2; // Define the number of chances they have, start at 2 since the first counter value is 0
    boolean answerCheck = false; // Define if they answer was right

    Scanner input =new Scanner(System.in);

    // Generate a for loop with a counter starting at 0
    // The loop will run either if they have more chances left
    // OR when they have gotten the answer right
    for(int i = 0; i < counter || answerCheck == true; i++) {

        System.out.print ("What is " + number1 + " + " + number2 + " ? " + "(You have three chances) "); // Output the question

        int answer = input.nextInt(); // Receive the answer

        if (number1 + number2 == answer) { // if they got the right ansser
            // Make the answerCheck true or use break here                
            answerCheck = true; 
            System.out.println("Answer is correct"); // Output the user got the correct answer
            //break; This will also work to end the loop
        } else { // they got the wrong answer
            System.out.println("Your answer is incorrect. You have " + counter - i + " chances left."); // Note they got the answer wrong and tell them how many chances they have left 
        }
    }
    if(!answerCheck) System.out.print(" You have failed"); // If they failed to get the answer correct, print out final statement.

}