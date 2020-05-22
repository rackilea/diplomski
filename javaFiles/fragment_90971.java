import java.util.Scanner;

public class StringSearch 
{
    public static void main(String[] args) 
    { 
        String[] nameArray = {"Stack", "Overflow"};
        String newName;
        int index;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nPlease enter in a name: ");
        newName = keyboard.nextLine();
        index = nameSearch(nameArray, newName);
        if (index != -1) {
            System.out.print("\nFound the name " + newName );
        }
        else {
            System.out.print("\nCannot find specified name " + newName);
        }
    }


    public static int nameSearch(String[] names, String name)
    {
        for (int n = 0; n < names.length; n++) {
            if (names[n].equals(name)) {
                return n;
            }
        }
        return -1;
    }
}