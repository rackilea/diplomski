public abstract class MyScreen implements Screen {

    protected HashMap<String, Button> buttons; // initialize this in the constructor

    // this is called in every game screen's game loop
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector2 touchCoords = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            g.viewport.unproject(touchCoords);
            for (HashMap.Entry<String, Button> b : buttons.entrySet()) {
                if (b.getValue().isClicked(touchCoords.x, touchCoords.y))
                    b.getValue().act();
            }
        }
    }
}