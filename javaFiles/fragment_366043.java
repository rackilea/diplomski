public boolean is_touched() {
    if (Gdx.input.justTouched()) {
        float xx = Gdx.input.getX();
        float yy = Gdx.input.getY();
        float x = position.x;
        float y = position.y;
        return (xx - x) * (xx - x) + (yy - y) * (yy - y) < radius * radius;
    }
}