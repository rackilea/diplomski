public class Game{

private Game game;
//private constructor
private Game(){};    

//synchronised method to create a game instance
private  synchronized static void createInstance () {
    if (game == null) game = new Game ();
}


public static void getInstance(){
  if(game==null){
    createInstance();
  }
  return game;
}