public class Parallax extends DynamicGameObject {

    public float width, height; // Use setter/getter if you prefer

    public Parallax(float x, float y, float width, float height, float velocityX, float velocityY) {

        super(x, y, width, height);
        velocity.set(velocityX, velocityY);
        this.width = width;
        this.height = height;

    }

    public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }
}