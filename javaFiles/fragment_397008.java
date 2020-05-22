@Override
public void resize(int width, int height) {
    // use true here to center the camera
    // that's what you probably want in case of a UI
    stage.getViewport().update(width, height, false);
}