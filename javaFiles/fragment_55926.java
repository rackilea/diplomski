import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        String userStr;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string to be manipulated");
        userStr = input.nextLine();

        while (true) {
            System.out.println("Enter your command");
            System.out.println("Print Reverse");
            System.out.println("Replace All");
            System.out.println("Replace Single");
            System.out.println("Remove");
            System.out.println("Quit");
            String choice = input.nextLine();
            String[] array = userStr.split("");

            if (choice.equalsIgnoreCase("Print Reverse")) { //reverses the string
                for(int i = array.length - 1;i >= 0; i --) {
                    System.out.print(array[i]);
                }
                System.out.println();
            }

            else if (choice.equalsIgnoreCase("Replace All")) { //Replaces all input letters with new letters that user inputs
                System.out.println("What letter would you like to replace?");
                String ridOf = input.nextLine();
                System.out.println("What letter do you want to replace it as?");
                String replace = input.nextLine();
                String[] newArray = array;
                for (int i = 0; i < array.length; i++) {
                    if(array[i].equals(ridOf)) {
                        array[i] = replace;
                    }
                }
                System.out.println("");
                for(int i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                }
                System.out.println("");
            }

            else if (choice.equalsIgnoreCase("Replace Single")) {
                System.out.println("Enter the character to replace?");
                String ridOf1 = input.nextLine();
                System.out.println("Enter the new character");
                String replace1 = input.nextLine();
                System.out.println("Which " + ridOf1 + " would you like to replace?");
                int choice1 = input.nextInt();

            }