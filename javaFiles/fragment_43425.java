class Player {
  String choice;
}

class Game {

static final ROCK = "ROCK";
static final PAPER = "PAPER";
static final SCISSORS = "SCISSORS";

  Scanner scanner = new Scanner();
  Player[] players = new Player[2]; //assuming you only want 2 players Use ArrayList for unspecified number of users and use a separate method to initialize it.

 public Game {
      for(int i =0 ; i<2 ; i++) {
         players[i]= new Player();
      }
 }

 private String getPlayerChoice() {
    System.out.println("Please enter your choice");
    System.out.println("1.Rock\n2.Paper\n3.Scissors")
    return scanner.nextLine();
 }

 void getInputAndValidate(Player p) {
  p.choice = getPlayerChoice();
  while(true) {
    if(p.choice.equalsIgnorecase(ROCK) || 
       p.choice.equalsIgnorecase(PAPER) || 
       p.choice.equalsIgnorecase(SCISSORS) ) {
         break;
    }
    else {
        System.out.println("Please enter a valid input");
        p.choice = getPlayerChoice(); \\ use the scanner as an instance variable.
    }
  }  
 }

 void getInput() {
    for(int i = 0; i<2;i++) {
     System.out.println("Player " + (i+1));
     getInputAndValidate(players[i]);
    }
 }

void compute(){
  // implement your game logic here
}
public static void main(String[] args) {
  Game g = new Game();
  g.getInput();
  g.compute();
}

}