import java.util.Scanner;

public class Tracy2prog1 {

    public static void main(String[] args) {
        //create new scanner class
        Scanner input = new Scanner(System.in);
        //prompt user to enter first middle and last name
        System.out.println("Please enter your first middle and last name with spaces between them");

        //Here you will have your names without " ", then its length is 2 characters shorter
        String[] names = input.nextLine().split(" ");

        //As your names are in an array now, you can get then directly
        System.out.println(names[0].length() + names[1].length() + names[2].length());
        System.out.println("The length of your middle name is " + names[1].length() + " characters");
        System.out.println("Your initials are " + names[0].charAt(0) + names[1].charAt(0) +names[2].charAt(0));
        System.out.println(names[0].toUpperCase() + " " + names[1].toUpperCase() + " " + names[2].toUpperCase());

        //Peggy Sue Palmer
        //Considering you did this: String[] names = input.nextLine().split(" ");
        //your array is ["Peggy", "Sue", "Palmer"]
        //then array[0] is "Peggy"
        //then "Peggy".length == 5
        //plus: names[0].charAt(0) means "Peggy".charAt(0) which is "P"
        System.out.println("The length of your first name is " + names[0].length() + " characters");
        System.out.println("The initial of your first name is " + names[0].charAt(0));
    }

}