import java.util.ArrayList;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> list = new ArrayList<>();
        System.out.println("Enter block size");
        int blockSize = scanner.nextInt();
        System.out.println("Enter data rows:");
        int count = 0;
        while (count < blockSize) {
            list.add(scanner.nextInt());
            list.add(scanner.next());
            list.add(scanner.next());
            count++;
        }
        System.out.println("\nThe data you entered is:");
        System.out.println(list);
    }
}