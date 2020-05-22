Vector2 position = new Vector2();
float t = 0;
public void render() {
    t = (t + Gdx.graphics.getDeltaTime()) % 1f;
    path.valueAt(position, t);
    // Now you can use the position vector
}