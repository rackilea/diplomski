public class DecoratorC extends Decorator {
    public DecoratorC(Decoratee decoratee){
      super(decoratee);
    }
    //methodA inherited from Decorator
    public int methodB(int argument){
      return someOhterInt + super.methodB(argument);
      //super.methodB calls Decorator.methodB which calls decoratee.methodB;
    }
}