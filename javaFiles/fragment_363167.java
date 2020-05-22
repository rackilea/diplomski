public abstract class Parent implements Clonable{

  private Object peer;

  // Example 1 
  public Parent() {
    try {
      peer = this.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

  // Example 2
  public Parent(String name) {
    try {
      peer = this.getClass().getConstructor(String.class).newInstance(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  } 

  public <T extends Parent> T getPeer() {
    return (T)peer;
  }
}

public class Child01 extends Parent { }

public class Child02 extends Parent { }