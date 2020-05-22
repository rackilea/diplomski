public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    if (screenX < Gdx.graphics.getWidth()/2)
        touchLeft = false;
    else
        touchRight = false;
}