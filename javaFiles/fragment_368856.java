import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList(
                "Baynes, Aron",
                "Bazemore, Kent",
                "Beal, Bradley",
                "Beasley, Malik",
                "Beasley, Michael",
                "Belinelli, Marco",
                "Bell, Jordan",
                "Bembry, DeAndre'"
        ));

        String separator = ", ";

        // Using loop
        for (String person : list) {
            String[] elements = person.split(separator);

            if (elements.length == 2) {
                System.out.printf("%s %s\n", elements[1], elements[0]);
            } else {
                System.out.println("Wrong line: " + person);
            }
        }

        // Using stream
        list.forEach(person -> {
            String[] elements = person.split(separator);

            if (elements.length == 2) {
                System.out.printf("%s %s\n", elements[1], elements[0]);
            } else {
                System.out.println("Wrong line: " + person);
            }
        });
    }
}