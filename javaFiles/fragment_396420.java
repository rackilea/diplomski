import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int [] array = new int[10];
        System.out.print("Insert the 10 values of your array.");
        for(int i=0; i<array.length; i++){
            array[i] = input.nextInt();
        }

        System.out.println("The even numbers in the array are...");
        System.out.println(Server.getEven(array));
        System.out.println("The odd numbers in the array are...");
        System.out.println(Server.getOdd(array));
        System.out.println("The negative numbers in the array are...");
        System.out.println(Server.getNeg(array));

        input.close();
    }
}