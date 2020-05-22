import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetExample {

public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    Set<Integer> ids = new HashSet<>();
    int id;

    while (scnr.hasNextInt()) {
        id = scnr.nextInt();

        if (ids.contains(id)) {
            System.out.println("invalid id");
        } else {
            ids.add(id);
            clients.put(new Integer(id), new Client(id));
        }
    }
}
}