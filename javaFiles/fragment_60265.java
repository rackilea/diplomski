import java.util.Scanner;

public class whatIsWrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;

        System.out.printf("%nEnter number of names desired names:  ");
        size = input.nextInt();

        String[] names = new String[size];

        for(int i = 0; i < size; i++) {
            System.out.printf("%nName #%d:  ", i +1);
            names[i] = input.nextLine();
        }
    }
}