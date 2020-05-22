x += ballSpeed * Gdx.graphics.getDeltaTime();

if (x >= camera.viewportWidth - 100) {
    x = camera.viewportWidth; // prevent overshooting
    ballSpeed *= -1;
} else if (x <= 0) {
    x = 0; // prevent overshooting
    ballSpeed *= -1;
}