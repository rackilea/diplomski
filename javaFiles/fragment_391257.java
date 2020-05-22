public class Main {
   private static final int[] start = new int[] { 1, 1 };

   public static void main(String[] args) {
      Robot robot = new Robot(start);
      robot.setDirection('d');
      Bala bala = new Bala(robot.getPosition(), robot.getDirection());

      for (int i = 0; i < 3; i++) {
         System.out.println("MOVING ONLY THE ROBOT...");
         robot.move();

         System.out.println("Robot position: "
               + String.valueOf(robot.getPosI()) + ", "
               + String.valueOf(robot.getPosJ()));
         System.out.println("Bullet position: "
               + String.valueOf(bala.getPosI()) + ", "
               + String.valueOf(bala.getPosJ()));

      }

      System.out.println("but the bullet moves to!!!");

      System.out.println("reseting position of robot and lets see what happens to bullet...");

      robot.resetPos();

      System.out.println("Robot position: " + String.valueOf(robot.getPosI())
            + ", " + String.valueOf(robot.getPosJ()));
      System.out.println("Bullet position: " + String.valueOf(bala.getPosI())
            + ", " + String.valueOf(bala.getPosJ()));

      System.out.println("bullet moves too...");
   }
}

abstract class Entity {
   protected int[] position = new int[2];
   protected char direction;

   public Entity(int[] position) {
      System.arraycopy(position, 0, this.position, 0, position.length);
   }

   public Entity(int[] position, char direction) {
      this(position);
      this.direction = direction;
   }

   public int getPosI() {
      // System.out.println("i: " + position[0]);
      return position[0];
   }

   public int getPosJ() {
      // System.out.println("j: " + position[1]);
      return position[1];
   }

   public int[] getPosition() {
      return position;
   }

   public void setPosition(int[] position) {
      this.position = position;
   }

   public char getDirection() {
      return direction;
   }

   public void setDirection(char direction) {
      this.direction = direction;
   }

   public boolean move() {

      switch (direction) {
      case 'u':
         if (this.position[0] != 0) {
            this.position[0]--;
            return true;
         } else
            return false;

      case 'r':
         if (this.position[1] != 3) {
            this.position[1]++;
            return true;
         } else
            return false;

      case 'd':
         if (this.position[0] != 3) {
            this.position[0]++;
            return true;
         } else
            return false;

      case 'l':
         if (this.position[1] != 0) {
            this.position[1]--;
            return true;
         } else
            return false;

      default:
         return false;
      }
   }
}

class Robot extends Entity {

   public Robot(int[] position) {
      super(position, 'u');

   }

   public void resetPos() {
      this.position[0] = this.position[1] = 1;
   }

}

class Bala extends Entity {

   public Bala(int[] position, char direction) {
      super(position, direction);
   }
}