import java.util.ArrayList;

public class ArrayListTestProgram {
    public static void main(String args[]) {
        int total = 0;
        ArrayList<Integer> numbers;
        numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(45);
        numbers.add(23);
        numbers.add(87);
        numbers.add(89);
        numbers.add(213);
        System.out.println("The ArrayList looks like this: " + numbers);
        System.out.println("It has " + numbers.size() + " elements in it");
        System.out.println("The 5th element in it is: " + numbers.get(4));
        int sum = 0;


        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);

        }
        System.out.println(sum);

    }
}