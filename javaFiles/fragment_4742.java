private void determineAction(char choice) {
   System.out.println(actionText.get(choice));
   switch (choice1)
   {
     case "x":                                        
         doExit();                              
         break;                                    
     case "i":
         printInventory();
         break;

   }
}

private void doExit()
{
    System.out.println("\nYou quit the game!");
    System.exit(0);
}

private void printInventory()
{
    System.out.println("\nInventory Items:");
    System.out.println("\n  Things are here");
}