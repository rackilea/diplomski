public abstract class Decorator implements Decoratee {
  private final Decoratee decoratee;
  public Decorator(Decoratee decoratee){
    this.decoratee = decoratee;
  }
  public int methodA(int argument){
    return decoratee.methodA(argument);
  }
  public int methodB(int argument){
    return decoratee.methodB(argument);;
  }
}