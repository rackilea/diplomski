Scanner keyboard = new Scanner(System.in);
String inp = keyboard.nextLine();
Random generator = new Random();
String newString = ""; //contains the extracted letters
int randomPositionOfLetter; 
for(int i=1;i<=3;i++){
    // calculating a random position of a char in the string
    randomPositionOfLetter = generator.nextInt(inp.length());
    newString = newString + inp.charAt(randomPositionOfLetter);
}