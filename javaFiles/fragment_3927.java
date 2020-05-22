import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class IntegersOccurence {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Enter the integers between 1 and 100: ");
        List<Integer> list = new ArrayList<Integer>();
        list.add(input.nextInt());
        System.out.println(list.get(0));
        //eclipse is showing an error in the line right below
        while (list.get(list.size() - 1) != 0) {
            list.add(input.nextInt());
        }   
    }
}