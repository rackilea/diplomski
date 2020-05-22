import java.util.Scanner ;
public class Menu {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner in = new Scanner(System.in); 
    // print menu
    for (int i = 1; i <= 5; i++)
          System.out.println(i + ". Menu item #" + i);
    System.out.println("0. Quit");
    // handle user commands
    //The name
    String first_name = "";
    String family_name = "";
    String full_name = "";
    while(true) {
          System.out.print("Choose menu item: ");
          int menuItem = 0;
          try { // If you enter a string it will throw an exception!
              menuItem = in.nextInt();
          } catch(Exception e) { 
              System.out.println(e.getMessage()); 
          }
          switch (menuItem) {
          case 1:
                System.out.println("You've chosen item #1");
                System.out.print("Enter your first name: ");
                first_name = in.next( );

                System.out.print("Enter your family name: ");
                family_name = in.next( );

                full_name = first_name + " " + family_name;
                System.out.println("You are " + full_name);
                break;
          case 2:
                System.out.println("You've chosen item #2");
                System.out.println("You are " + full_name);
                break;
          case 3:
                System.out.println("You've chosen item #3");
                // do something...
                break;
          case 4:
                System.out.println("You've chosen item #4");
                // do something...
                break;
          case 5:
                System.out.println("You've chosen item #5");
                // do something...
                break;
          case 0:
                System.out.println("bye-bye");
                System.exit(0); // Exit
                break;
          default:
                System.out.println("Invalid choice.");
          }
      }
   }
}