public class DecoratorB extends Decorator {
    public DecoratorB(Decoratee decoratee){
      super(decoratee);
    }
    //methodA inherited from Decorator
    public int methodB(int argument){
      return someOhterInt;
    }
}