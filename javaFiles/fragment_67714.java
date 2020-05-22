public interface CollisionEventHandler extends EventHandler {
  void onCollision(CollisionEvent event);  
}

public class Sprite implements CollisionEventHandler {
  public void onCollision(CollisionEvent data) {
    System.out.println("HI");
  }
}

public class EventDispatcher {
  ...

  static void call(final CollisionEvent event) {
    getRegistered().stream()
          .filter(handler -> handler instanceof CollisionEventHandler)
          .map(handler -> (CollisionEventHandler) handler)
          .forEach(handler -> handler.onCollision(event));
  }
}