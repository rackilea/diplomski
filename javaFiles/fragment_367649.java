import java.util.Scanner;

public abstract class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of elements");
        int num_of_elements = Integer.parseInt(input.next());
        String[] elements =new String[num_of_elements];
        for(int i = 0; i < num_of_elements; i++){
            System.out.println("Please enter an element");
            elements[i]= input.next() + " ";
        }
        for(int i = 0; i < num_of_elements; i++){
            System.out.println("[" + elements[i] + "]");
        }
    }
}