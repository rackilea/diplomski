public class Mammal {
int health =500;
  public void takeDamage(int damage) throws Exception{
    if(damage < 1) {
      throw new Exception("Damage cant be negative!");
    }
    else this.health -= damage;
  }