public class GameEngine{
      GameWindow window;

      public GameEngine(GameWindow gm){
           window = gm;
      }
      //rest of your code
 }

 public class GameWindow(){

     //At the point where you create the GameEngine
     GameEngine ge = new GameEngine(this);
     //rest of your code


}