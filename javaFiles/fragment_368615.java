public class SceneB implements Screen {

    private Stage stage;

    @Override
    public void show() {
        System.out.println("\nshow SceneB");

        stage = new Stage(new StretchViewport(1920, 1080));

        Image button = new Image(new Texture("____.png"));
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ((Game) Gdx.app.getApplicationListener()).dispose();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new SceneA());
            }
        });

        stage.addActor(button);

        // don't forget to call this to be able to handle stage inputs
        Gdx.input.setInputProcessor(stage);
    }

    // ........ here remaining methods (resize(), resume(), pause(), hide())
    @Override
    public void dispose() {
        stage.dispose();
        System.out.println("\ndispose SceneB");
    }
}