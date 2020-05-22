public class SpriteTest {

    public static void main(String[] args) {
        EventDispatcher.register(new Sprite());

        CollisionEvent collisionEvent = new CollisionEvent();
        EventDispatcher.dispatch(collisionEvent);
    }
}