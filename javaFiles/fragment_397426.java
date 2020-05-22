import java.util.Scanner;

class Menu 
{   
    private String menuText;
    private int optionCount;

    public Menu()
    {
        menuText = "";
        optionCount = 0;
    }

    public void addOption(String option)
    {
        optionCount = optionCount + 1;
        menuText = menuText + optionCount + ") " + option + "\n";
    }

    public void display()
    {
        System.out.println(menuText);
    }
}

public class MenuDemo{
    public MenuDemo() 
    {
    }

    public static void main(String[] args) 
    {
        Menu mainMenu = new Menu();
        mainMenu.addOption("1. Log In Account");
        mainMenu.addOption("2. Deposit Check");
        mainMenu.addOption("3. Help");
        mainMenu.addOption("4. Quit");
        mainMenu.display();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Choice: ");
        String i = input.nextLine();

        switch(i){

        case "1":
            //do something
            System.out.println("User Entered 1 : " + i);
            break;
        case "2":
            //do something
            System.out.println("User Entered 2 : " + i);
            break;
        case "3":
            //do something
            System.out.println("User Entered 3 : " + i);
            break;
        case "4":
            //do something
            System.out.println("User Entered 4 : " + i);
            break;
        default:
            System.out.println("Quit" + i);
        }


    }

}