checkBox.addListener(new ChangeListener() {
    @Override
    public void changed (ChangeEvent event, Actor actor) {
        Gdx.graphics.setContinuousRendering(checkBox.isChecked());
    }
});