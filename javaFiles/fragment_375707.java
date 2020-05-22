import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = getInput(sc);
        String result;

        switch (choice) {
            case ('a'): 
                result = "u choose a";
                System.out.println(result);

                //I wish to display result from getInputA method here as well.
                result = getInputA(sc);
                System.out.println(result);
                break;
        }
    }

    private static char getInput(Scanner sc) 
    {
        System.out.println("Enter a");
        char choice = sc.nextLine().trim().toLowerCase().charAt(0); 

        while (choice != 'a')
        {
            System.out.println("You have entered an invalid entry.");
            System.out.println("Enter a");
            choice = sc.nextLine().trim().toLowerCase().charAt(0);
        }
        return choice;
    }
    private static String getInputA(Scanner sc) 
    {
        System.out.print("Enter your first name: ");
        String fName=sc.next();
        System.out.print("Enter your last name: ");
        String lName=sc.next();
        String output=("Your name is: "+fName+ " " +lName);
        return output;
    }
}