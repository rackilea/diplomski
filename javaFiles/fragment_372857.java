import java.util.Scanner;

public class HandleException {
    public static void main(String[] args) {
        int data = 0;
        int data1 = 0;
        int sum = 0;

        Scanner input = new Scanner(System.in);
        // ask user for a command
        System.out.println("Which side would you like to start with A or B");
        String s = input.next();
        char letter = s.charAt(0);

        while (letter != 'q') {

            switch (letter) {

            // if user inputs 'A'
            case 'a':

                System.out.println("Enter value for side A: ");
                data = input.nextInt();
                System.out.println("Enter next command: A : value for side A; B : Value for side B; C: Calculate; Q : Quit program.");
                s = input.next();
                letter = s.charAt(0);
                if (letter == 'b')
                    System.out.println("Enter Value For side B: ");
                data1 = input.nextInt();
                System.out.println("Enter next command: A : value for side A; B : Value for side B; C: Calculate; Q : Quit program.");
                s = input.next();
                letter = s.charAt(0);
                if (letter == 'c')
                    sum = data * data + data1 * data1;
                int sumsrt = (int) Math.sqrt(sum);
                System.out.println("The hypotenuse is:  " + sumsrt);
                break;

                // if user inputs 'B'
            case 'b':
                System.out.println("Enter value for side B: ");
                data = input.nextInt();
                System.out.println("Enter next command: A : value for side A; B : Value for side B; C: Calculate; Q : Quit program.");
                s = input.next();
                letter = s.charAt(0);
                if (letter == 'a')
                    System.out.println("Enter Value For side a: ");
                data1 = input.nextInt();
                System.out.println("Enter next command: A : value for side A; B : Value for side B; C: Calculate; Q : Quit program.");
                s = input.next();
                letter = s.charAt(0);
                if (letter == 'c')
                    sum = data * data + data1 * data1;
                int sumsrt1 = (int) Math.sqrt(sum);
                System.out.println("The hypotenuse is:  " + sumsrt1);
                break;

            }

            System.out.println("Which side would you like to start with A or B");
            s = input.next();
            letter = s.charAt(0);

        }
    }
}