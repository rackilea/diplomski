public interface Behaviour { void action(); }

public class Bark implements Behaviour {...}
public class ChaseCat implements Behaviour { ... }
public class Eat implements Behaviour {...}
public class Sleep implements Behaviour {...}
... others
public class Dog {

  private List<Behaviour> behaviours;

  public Dog(Behaviour...behaviors) { this.behaviors = Arrays.asList(behaviours); }

  public void play() { 
   // choose random behaviour
   behaviour.action();
  }
}

Dog dog1 = new Dog(new ChaseCat(), new Bark());
Dog dog2 = new Dog(new Eat(), new Sleep());