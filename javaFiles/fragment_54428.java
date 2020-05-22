import java.util.Scanner;

public class dank{
    public void design(){
        System.out.println("---------------------------------");
        System.out.println("| Main Checmicals in Substances |");
        System.out.println("---------------------------------");
        System.out.println("| LSD | SHROOMS | WEED |");
        System.out.println("------------------------");
        System.out.print("\nWhich substance would you like to learn about?\nInput: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        catchError(choice);
    }

    public void catchError(String choice){
        try{
            if(choice.equalsIgnoreCase("LSD"))
            {
                System.out.println("\nMain Chemical: Lysergic Acid Diethylamide");
                System.out.println("Fatal: NO");
            }
            else if(choice.equalsIgnoreCase("SHROOMS"))
            {
                System.out.println("\nMain Chemical: Psilocybin");
                System.out.println("Fatal: NO");
            }
            else if(choice.equalsIgnoreCase("WEED"))
            {
                System.out.println("\nMain Chemical: THC");
                System.out.println("Fatal: HELL NO");
            }
            else
            {
                System.out.println("\nInvalid Input!");
                design();
            }
        }

        catch(Exception e)
        {
            System.out.println("\nInvalid Input!");
            design();
        }

    }
}