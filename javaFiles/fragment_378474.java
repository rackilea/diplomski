MyGdxGame gdxGame;

@Override
protected void onCreate (Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
     gdxGame = new MyGdxGame();
     View gameView = initializeForView(gdxGame, config);

     setContentView(gameView);
}