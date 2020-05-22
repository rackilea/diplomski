import java.io.*;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File f = new File("/tmp/output.txt");

        System.out.println("How many lines do you want to write? ");
        int mida = sc.nextInt();
        sc.nextLine(); // Consume next empty line

        try (FileWriter escriptor = new FileWriter(f)) {

            for (int i = 0; i < mida; i++) {
                System.out.println(String.format("Write line %d:", i + 1));
                String paraula = sc.nextLine();
                escriptor.write(String.format("%s\n", paraula));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}