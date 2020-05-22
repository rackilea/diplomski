public class ScaryMonster {
  Animal animal;
  public  ScaryMonster(Animal animal) {
      this.animal = animal;
  }

  public void fly() {
      if(animal instanceof FlyingAnimal ) {
        ((FlyingAnimal )animal).fly();
      }
      else {
        throw new Exception("This mosnter cannot fly");
      }     
  }

  public void run() {
    if(animal instanceof RunningAnimal ) {
        ((RunningAnimal )animal).run();
      }
      else {
        throw new Exception("This mosnter cannot run");
      }
  }

  public void sneakAround() {
    ...
  }
}