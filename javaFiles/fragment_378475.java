public class AndroidLauncher extends AndroidApplication implements Service {
    MyGdxGame gdxGame;

   @Override
   protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        gdxGame = new MyGdxGame(this);
        View gameView = initializeForView(gdxGame, config);

        setContentView(gameView);
    }

    @Override
    public void doSomething() {
        //do what you want 
    } 

    ...
}