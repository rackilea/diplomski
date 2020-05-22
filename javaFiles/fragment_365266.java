public class GameEngine {
    private static GameEngine instance = null;

    private GameEngine(){
       // init stuff here
    }

    public static GameEngine getInstance(){
       if(instance == null){
          instance = new GameEngine();
       }
       return instance;
    }
}