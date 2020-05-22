public static void processCommandLine(String[] commandArgs, GraphicsScreen graphics) {
   if (commandArgs == null || commandArgs.length = 0 || commandArgs[0] == null) {
      System.out.println("Null command!");
   }

   String command = commandArgs[0];

   if (command.trim().equalsIgnoreCase("move")) {
      int x = 0;
      int y = 0;

      x = Integer.parseInt(commandArgs[1]);
      y = Integer.parseInt(commandArgs[2]);

      graphics.moveTo(x, y);
   }

   else if (command.trim().equalsIgnoreCase("circle")) {
      int radius = Integer.parseInt(one[1]);
      graphics.circle(radius);

   }

   else if (command.trim().equalsIgnoreCase("line")) {
      int x = 0;
      int y = 0;

      x = Integer.parseInt(commandArgs[1]);
      y = Integer.parseInt(comamndArgs[2]);

      graphics.lineTo(x, y);
   }

   else if (command.trim().equalsIgnoreCase("clear")) {
      graphics.clear();
   }
   else {
      System.out.println("Invalid Command!");
   }
}