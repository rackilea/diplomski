import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Program {

    private String[] userInput;
    private int inputNumber;

    public Program(String input) {
        this.userInput = input.split(" ");
        this.inputNumber = 0;
    }

    public void startGame() {
        int random_num = (int)(Math.random()*100)+1;

        System.out.println("Guess the number between 1 and 100!");

        boolean isCorrect = false;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess "+ i +": ");
            int input = getInput();
            if (input > random_num)
                System.out.println("It is less than " + input);
            else if (input < random_num)
                System.out.println("It is more than " + input);
            else {
                isCorrect = true;
                break;
            }
        }

        if(isCorrect)
            System.out.println("Congratulations, you have guessed the correct number i.e " + random_num);
        else
            System.out.println("Game over! The number was " + random_num);
    }

    private int getInput() {
        if (inputNumber < userInput.length)
            fakeUserInput();

        Scanner sc = new Scanner(System.in);
        int input = -1;
        input = sc.nextInt();

        if (inputNumber == userInput.length)
            sc.close();

        return input;
    }

    private void fakeUserInput() {
        System.setIn(new ByteArrayInputStream(userInput[inputNumber].getBytes()));
        inputNumber++;
    }

    public static void main(String[] args) {
        Program p = new Program("10 20 30");
        p.startGame();
    }
}