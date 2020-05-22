public MyApp extends ApplicationAdapter { 

    private Stage currentStage;

    private static MyApp instance;

    // ...

    @Override
    public void create () {
        instance = this;
        MyApp.setStage(new MainMenu()); // The game begins in the main menu
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0.15f, 0.1f, 0.15f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        currentStage.act();
        currentStage.draw();
    }

    public static void setStage(Stage stage){
        instance.currentStage = stage;
        Gdx.input.setInputProcessor(stage); // Important ;)
    }

    // ...

}