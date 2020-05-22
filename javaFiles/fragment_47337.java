import java.util.Arrays;
import java.util.Scanner;

public class StringSort2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 0;
        String[] arr = new String[15];
        do {
            System.out.print("Enter item or type 'zzz' to quit: ");
            arr[counter] = input.nextLine();
            if (arr[counter].equals("zzz")) {
                System.out.println("bleh");
            } else {
                counter++;
            }
        } while (!"zzz".equals(arr[counter]) && counter <= 14);
        arr = Arrays.copyOf(arr, counter);
        Arrays.sort(arr);
        System.out.println("Array is " + Arrays.toString(arr));
    }
}