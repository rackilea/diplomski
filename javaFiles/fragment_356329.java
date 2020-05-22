public class DecoratorA extends Decorator {
    public DecoratorA(Decoratee decoratee){
      super(decoratee);
    }
    public int methodA(int argument){
      return someOhterInt;
    }
    //methodB inherited from Decorator
}