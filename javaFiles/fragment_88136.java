import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment3 {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new FileReader("aptunits.txt"));

        int unit = 1;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);

            double total = 0;

            int assistants = input.nextInt();
            System.out.println("Number of Assistants " + assistants);
            System.out.println("Hours  Rate");
            System.out.println("------------");
            for (int i = 0; i < assistants; i++) {
                int hours = input.nextInt();
                System.out.print(hours + "     ");
                double rate = input.nextDouble();
                System.out.println(rate);               
                total += (hours * rate);
            }
            System.out.println("Total cost of Unit " + unit + " is " + total);
            System.out.println();
            unit++;

            if (input.hasNextLine()) {
                input.nextLine();
                input.next();
            }

        } 
    }
}