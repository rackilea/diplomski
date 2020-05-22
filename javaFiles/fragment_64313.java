private float timer = 10;
@Override
public void render(float delta) {

    timer -= delta;

    if (Obstacle.activeItem == true) {
        font.draw(batch, "Item active for: " + (int)timer, 100, 680);
    }
}