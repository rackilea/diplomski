import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line;
        System.out.println("Insert line (empty terminates the program):");

        while(!(line = scanner.nextLine()).isBlank()){
            String[] segments = line.split(" ", 2);

            int population = Integer.parseInt(segments[0]);
            String[] sequence = segments[1].trim().split(" ");
            if(population != sequence.length){
                System.err.println("Population declaration and sequence size do not match\nPopulation: " + population + "\nSequence: "+ segments[1] + ", size: " + sequence[1].length());
                System.exit(0);
            }

            int max = Integer.MIN_VALUE;

            for (String number : sequence) {
                max = Math.max(Integer.parseInt(number), max);
            }

            System.out.println(max);
            System.out.println("Insert line (empty terminates the program):");
        }

        System.out.println("Now exiting");
    }

}