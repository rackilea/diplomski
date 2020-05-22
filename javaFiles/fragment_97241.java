import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++)
            numbers.add(scan.nextInt());

        for (Integer num : numbers)
            System.out.println(num);
    }
}