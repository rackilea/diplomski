private float fireDelay;

public void render(float deltaTime) {
    fireDelay -= deltaTime;
    if (keys.get(Keys.FIRE)) {
        player.setState(State.FIRING);
        if (fireDelay <= 0) {
            world.addBullet(new Bullet(1f,1f,0));
            fireDelay += 0.2;
        }
    }
}