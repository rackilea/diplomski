System.out.print("(Player 2) Guess a letter: ");
Scanner letterScan = new Scanner(System.in);
String line = "";
//just check for one character.
while((line=letterScan.nextLine()).length()!=1)
{
    System.out.print("(Player 2) Please guess only one letter: ");
}
char inputLetter = line.charAt(0);
System.out.println("letter: " + inputLetter);