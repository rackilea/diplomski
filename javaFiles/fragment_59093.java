public class Weapon {
   private final Bullet template;

   public Weapon(Bullet template) {
      this.template = template;
   }
   /* shoot logic here */
}

public class Bullet { 
   private final Vector2 position;
   private final float velocity;
   public Bullet(float speed) {
      this.position = new Vector2();
      this.speed = speed;
   }
   /* setters and getters */
}