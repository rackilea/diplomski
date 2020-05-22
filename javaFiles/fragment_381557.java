button.addListener(new InputListener() {

    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        changed = true;
        count = 0;
    }

    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        changed = true;
        count = 0;
    }
});