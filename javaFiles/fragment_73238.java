System.out.println("\nAdventure Game - Start!\n");
System.out.println("Here are the characters:");
System.out.println("1. Rogue\n2. Paladin\n3. Jackie Chan\n");

Player player;
System.out.print("Which character do you choose?: ");
characterChoice = keyboard.nextInt();
switch(characterChoice){
case 1:
   player = new Player(Type.ROGUE);
   break;


}
System.out.printf("\nYou chose: %s\n\n", player);