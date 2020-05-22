@Override
public void show() {
    Gdx.input.setInputProcessor(stage);
}

@Override
public void hide() {
    Gdx.input.setInputProcessor(null);
}