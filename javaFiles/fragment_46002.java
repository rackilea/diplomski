@Override
public boolean pan(float x, float y, float deltaX, float deltaY) {
    message = "PAN";
    Gdx.app.log("INFO", message);

    gameCam.translate(-deltaX * currentZoom,deltaY * currentZoom);
    gameCam.update();
    return false;
}
@Override
public boolean zoom(float initialDistance, float distance) {
    message = "Zoom performed";
    Gdx.app.log("INFO", message);

    gameCam.zoom = (initialDistance / distance) * currentZoom;
    gameCam.update();

    return true;
}
@Override
public boolean panStop(float x, float y, int pointer, int button) {
    Gdx.app.log("INFO", "panStop");
    currentZoom = gameCam.zoom;
    return false;
}