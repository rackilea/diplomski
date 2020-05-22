import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDiver {

    public static void main(String[] args) {
        Scanner in = new Scanner("diving_data.txt");
        List<Diver> divers = new ArrayList<>();
        while (in.hasNext()) {
            String firstName = in.next();
            String lastName  = in.next();

            Diver diver = new Diver(firstName, lastName);
            while(in.hasNextDouble()) {
                diver.addScore(in.nextDouble());
            }
            divers.add(diver);
        }
        in.close();

        for (Diver eachDiver : divers) {
            System.out.format(
                    "%s %s - %.2f points%n", 
                    eachDiver.getFirstName(), 
                    eachDiver.getLastName(), 
                    eachDiver.getFinalScore());
        }
    }
}