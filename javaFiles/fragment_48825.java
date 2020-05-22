private void calculatePosition(float x, float y) {
    float minX = 0;
    float maxX = Gdx.graphics.getWidth() - sprite.getWidth();
    float minY = 0;
    float maxY = Gdx.graphics.getHeight() - sprite.getHeight();

    float newX = Math.min(maxX, Math.max(x, minX));
    float newY = Math.min(maxY, Math.max(y, minY));

    sprite.setPosition(newX, newY);
}