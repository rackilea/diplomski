Map<Character, String> actionText = new HashMap<Character, String>();

actionText.put('x', "\nYou quit the game!");
actionText.put('i', "\nInventory Items:\n  Things are here");


private void determineAction(char choice) {
   System.out.println(actionText.get(choice));
   switch (choice1)
   {
     case "x":                                        
         System.exit(0);                               
     break;                                    
   }
}