import java.util.Random;
public final class Kidwell_Lab09 {
    public static Random generator = new Random();

    public static void main(String[] args) {
        int x;

        int[] randomNumbers = new int[20];
        Scanner inputReader = new Scanner(System.in);
        do {
            Random generator = new Random();
            for (int i = 0; i < randomNumbers.length; i++) {
                int n = generator.nextInt(10) + 1;
                randomNumbers[i] = n;
            }

            for (int i = 0; i < randomNumbers.length; i++) {
                System.out.println("Number " + i + " : " + randomNumbers[i]);
            }
            System.out.print("Do you wish to restart the program, Enter 1 for YES, 2              for NO: ");            
            x = inputReader.nextInt();
        } while (x == 1);
    }    
}