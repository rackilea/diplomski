import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindString {
    public static List<String> names = new ArrayList<String>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        names.add("me-22222");
        names.add("us-33333");
        names.add("you-44444");
        names.add("they-55555");

        System.out.println("Enter name: ");
        String toCheck = scanner.next();

        for(String s : names) {
            String[] parts = s.split("-");
            String name = parts[0]; 
            int number = Integer.parseInt(parts[1]);
            if(toCheck.equals(name))
                System.out.println("This name already got a number : " + number);
            else 
                System.out.println("There is no number connected with this name!");

        }
    }
}