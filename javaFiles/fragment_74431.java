public class UserLog {
   private String username;
   // more variables...

   private final Scanner in;

   public UserLog() {
      in = new Scanner(System.in);
   }

   public static void main(String[] args) {
      UserLog userLog = new UserLog();
      userLog.showMenu();
   }

   public void menu() {
      boolean call = false;

      do {
         try {
            System.out.println("Select an option: ");
            System.out.println("1: New account \n" + "2: Existing account");
            System.out.print("-");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
            case 1:
               call = true;
               System.out.println("\nNew account called\n");
               userCreate();
               break;
            case 2:
               call = true;
               System.out.println("\nExisting account called\n");
               login();
               break;
            default:
               System.out.println("\nNot a valid option\n");
            }

         } catch (InputMismatchException e) {
            System.out.println("Invalid option " + in.nextLine());
         }
      } while (!call);
   }
   ...
}