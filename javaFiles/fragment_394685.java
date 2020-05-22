import java.util.*;

public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of people in your group, up to 6");
        int num = input.nextInt();

        if (num > 6) {
            System.out.println("You have exceeded the maximum amount of people allowed.");
        }

        int highest = num - 1;
        ArrayList<Integer> available = new ArrayList<Integer>();
        Integer[] booking = new Integer[0];
        int[] RowA = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0};

        for (int i = 0; i < RowA.length; i++) {
            if (RowA[i] == 0) {
                available.add(i + 1);
            }
            if (available.size() > booking.length) {
                booking = available.toArray(booking);
                System.out.println(Arrays.toString(booking));
            } else if (RowA[i] == 1) {
                available.clear();
            }
        }


        if (num <= booking.length) {
            int low = booking[0];
            int high = booking[highest];
            System.out.println("There are seats from " + low + " - " + high + ".");
        } else {
            System.out.println("The desired seat amount is not available. The maximum amount on Row is " + booking.length);
        }
    }
}