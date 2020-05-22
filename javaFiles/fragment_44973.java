public static void main(String [] args){
    Scanner input = new Scanner(System.in);  
    CounterGameCounter game = new CounterGameCounter();
    System.out.println("You want to play a game I see. What is your name?");
    String name = input.next();
    game.NameIn(name);
    CounterGAME game1 = new CounterGAME();    
    game1.actual(game);
    // more stuff
}