public abstract class SuperClass{
  public abstract SuperClass getSelf();
}

public class SubClass extends SuperClass{
  @Override
  public SubClass getSelf(){
    return this;
  }
}