public final static void main(String[] args) {
   System.out.println("Let's draw something on the screen!");

   GraphicsScreen graphics = new GraphicsScreen();

   Scanner input = new Scanner(System.in); // used to read the keyboard

   String next; // stores the next line input
   String[] one;

   do {
      System.out.print("Enter a command (\"stop\") to finish : ");
      System.out.print("Type 'help' for a list of commands ");
      next = input.nextLine();
      one = next.split(" ");

      String command = one[0];

      if (command.trim().equalsIgnoreCase("help")) {
         System.out
               .println("Type 'move' followed by an X and Y co-ordinate to move the graphical pointer.");
         System.out
               .println("Type 'circle' followed by a radius value to output a circle.");
         System.out
               .println("Type 'line' followed by an X and Y co-ordinate to draw a line.");
         System.out.println("Type 'clear' to reset the graphical canvas.");
      }

      else if (command.trim().equalsIgnoreCase("load")) {
         List<String> commandLines = getCommands(one[1]);
         for (String commandLine : commandLines) {
            String[] commandArgs = commandLine.split(" ");
            processCommandLine(commandArgs, graphics);
         }
      }

      else if (command.trim().equalsIgnoreCase("stop")) {
         break;
      }

      else {
         processCommandLine(one, graphics);
      }
   } while (true);

   System.out
         .println("You have decided to stop entering commands. Program terminated!");
   graphics.close();
}