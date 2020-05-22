public abstract class Unit {
  private int health;
  private int power;
  private int moves;
  private int movement;

    protected Unit(int health, int power, int moves, int movement) {
      health = health;
      power = power;
      moves = moves;
      movement = movement;
    }

}

public class Medic extends Unit {

    public Medic() {
      super(1000, 100, 6, 8);
    } 

    public Medic(int health, int power, int moves, int movement) {
      super(health, power, moves, movement);
    }

    public void Heal(Unit target) {
      moves -= 2;
      target.health += 200;
    }
}