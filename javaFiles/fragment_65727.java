public class Ball {

    public static final float GRAVITY = -100; // size depends on your world scale
    public static final float BOUNCE_DAMPENING = 0.6f;

    public final Vector2 position = new Vector2();
    public final Vector2 velocity = new Vector2();
    public final Vector2 acceleration = new Vector2(0, GRAVITY);

    public void update (){
        float dt = Gdx.graphics.getDeltaTime();
        velocity.add(acceleration.x * dt, acceleration.y * dt));
        position.add(velocity.x * dt, velocity.y * dt);

        if (position.y <= 0){ // hit ground, so bounce
            position.y = -position.y * BOUNCE_DAMPENING;
            velocity.y = -velocity.y * BOUNCE_DAMPENING;
        }
    }

}